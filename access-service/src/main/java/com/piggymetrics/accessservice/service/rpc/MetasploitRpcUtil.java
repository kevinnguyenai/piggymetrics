package com.piggymetrics.accessservice.service.rpc;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.piggymetrics.accessservice.client.MetasploitClient;
import com.piggymetrics.accessservice.domain.metasploit.Authen;
import com.piggymetrics.accessservice.domain.metasploit.AuthenResult;
import com.piggymetrics.accessservice.util.MetasploitUtil;
import com.piggymetrics.accessservice.util.MetasploitUtilEx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


/**
 * @author Kevin
 */
@Service
public class MetasploitRpcUtil implements MetasploitRpc{
    
    @Autowired
    private static final Logger log = LoggerFactory.getLogger(MetasploitRpcUtil.class);

    @Autowired
    MetasploitClient client;

    @Autowired
    private MetasploitUtil util;

    @Autowired
    private MetasploitUtilEx extendUtil;

    @Autowired
    private Environment env;

    /**
     * {@inheritDoc}
     */
    @Override
    @Cacheable(value="loginCache")
    public String login(Authen auth) throws IOException {
        //byte[] acc = util.encode(auth.getUser(), auth.getPass(), auth.getSsl());
        //log.info("MesasgePack {}", acc);
        //log.info("Properties {}", env.getProperty("feign.httpclient.disableSslValidation"));

        ArrayList<String> args = new ArrayList<String>();
        args.add(auth.getUser());
        args.add(auth.getPass());
        byte[] acc = util.encode("auth.login", args);
        byte[] res = client.login(acc);
        AuthenResult result = new AuthenResult();
        try {
            result = util.decodeAuthenResult(res);
            ObjectWriter ow = new ObjectMapper().writer();
            String json = ow.writeValueAsString(result);
            return json;
        } catch(IOException ex) {
            ex.printStackTrace();
            return result.toString();
        }
    }

    /**
     * {@inheritDoc}
     */
    public String moduleExecute(String token, String moduleType, String moduleName, String host, String port) throws IOException {
        ArrayList<String> args = new ArrayList<String>();
        args.add(token);
        args.add(moduleType);
        args.add(moduleName);
        byte[] data = extendUtil.extendMetasploitModuleExecutorEncode("module.execute", args, host, port);
        log.info("EXECUTOR DATA = {}", data);
        byte[] res = client.execute(data);
        try {
            String result = extendUtil.decodeExecutor(res);
            return result;
        } catch(IOException ex) {
            ex.printStackTrace();
            return res.toString();
        }
    }
    
    /**
     * {@inheritDoc}
     * @throws IOException
     */
    public String moduleInfo(String token, String moduleType, String moduleName) throws IOException {
        ArrayList<String> args = new ArrayList<String>();
        args.add(token);
        args.add(moduleType);
        args.add(moduleName);
        byte[] data = util.customMetasploitModuleInfoEncode("module.info", args);
        log.info("EXECUTOR DATA = {}", data);
        byte[] res = client.execute(data);
        try {
            String result = util.decodeExecutor(res);
            return result;
        } catch(IOException ex) {
            ex.printStackTrace();
            return res.toString();
        }
    }

    /**
     * {@inheritDoc}
     */
    public String jobInfo(String token, String jobID) throws IOException {
        ArrayList<String> args = new ArrayList<String>();
        args.add(token);
        args.add(jobID);
        byte[] data = extendUtil.extendMetasploitEncode("job.info", args);
        log.info("EXECUTOR DATA = {}", data);
        byte[] res = client.execute(data);
        try {
            String result = extendUtil.decodeExecutor(res);
            return result;
        } catch(IOException ex) {
            ex.printStackTrace();
            return res.toString();
        }
    }

    /**
     * {@inheritDoc}
     */
    public String proTaskLog(String token, String jobID) throws IOException {
        ArrayList<String> args = new ArrayList<String>();
        args.add(token);
        args.add(jobID);
        byte[] data = extendUtil.extendMetasploitEncode("pro.task_log", args);
        log.info("EXECUTOR DATA = {}", data);
        byte[] res = client.execute(data);
        try {
            String result = extendUtil.decodeExecutor(res);
            return result;
        } catch(IOException ex) {
            ex.printStackTrace();
            return res.toString();
        }   
    }

    /**
     * {@inheritDoc}
     */
    public String sessionList(String token) throws IOException {
        ArrayList<String> args = new ArrayList<String>();
        args.add(token);
        byte[] data = extendUtil.extendMetasploitEncode("session.list", args);
        log.info("EXECUTOR DATA = {}", data);
        byte[] res = client.execute(data);
        try {
            String result = extendUtil.decodeExecutor(res);
            return result;
        } catch(IOException ex) {
            ex.printStackTrace();
            return res.toString();
        }     
    }

    /**
     * {@inheritDoc}
     */
    public String sessionShellRead(String token, String sessionID) throws IOException {
        ArrayList<String> args = new ArrayList<String>();
        args.add(token);
        args.add(sessionID);
        byte[] data = extendUtil.extendMetasploitEncode("session.shell_read", args);
        log.info("EXECUTOR DATA = {}", data);
        byte[] res = client.execute(data);
        try {
            String result = extendUtil.decodeExecutor(res);
            return result;
        } catch(IOException ex) {
            ex.printStackTrace();
            return res.toString();
        }  
    }

    /**
     * {@inheritDoc}
     */
    public String consoleCreate(String token) throws IOException {
        ArrayList<String> args = new ArrayList<String>();
        args.add(token);
        byte[] data = extendUtil.extendMetasploitEncode("console.create", args);
        log.info("EXECUTOR DATA = {}", data);
        byte[] res = client.execute(data);
        try {
            String result = extendUtil.decodeExecutor(res);
            return result;
        } catch(IOException ex) {
            ex.printStackTrace();
            return res.toString();
        }  
    }

    /**
     * {@inheritDoc}
     */
    public String consoleList(String token) throws IOException {
        ArrayList<String> args = new ArrayList<String>();
        args.add(token);
        byte[] data = extendUtil.extendMetasploitEncode("console.list", args);
        log.info("EXECUTOR DATA = {}", data);
        byte[] res = client.execute(data);
        try {
            String result = extendUtil.decodeExecutor(res);
            return result;
        } catch(IOException ex) {
            ex.printStackTrace();
            return res.toString();
        } 
    }

    /**
     * {@inheritDoc}
     */
    public String consoleWrite(String token, String consoleID, String consoleCommand) throws IOException {
        ArrayList<String> args = new ArrayList<String>();
        args.add(token);
        args.add(consoleID);
        args.add(consoleCommand);
        byte[] data = extendUtil.extendMetasploitEncode("console.write", args);
        log.info("EXECUTOR DATA = {}", data);
        byte[] res = client.execute(data);
        try {
            String result = extendUtil.decodeExecutor(res);
            return result;
        } catch(IOException ex) {
            ex.printStackTrace();
            return res.toString();
        } 
    }

    /**
     * {@inheritDoc}
     */
    public String consoleRead(String token, String consoleID) throws IOException {
        ArrayList<String> args = new ArrayList<String>();
        args.add(token);
        args.add(consoleID);
        byte[] data = extendUtil.extendMetasploitEncode("console.read", args);
        log.info("EXECUTOR DATA = {}", data);
        byte[] res = client.execute(data);
        try {
            String result = extendUtil.decodeConsole(res);
            return result;
        } catch(IOException ex) {
            ex.printStackTrace();
            return res.toString();
        } 
    }
}

