package com.piggymetrics.accessservice.controller;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.netflix.discovery.converters.Auto;
import com.piggymetrics.accessservice.domain.metasploit.Authen;
import com.piggymetrics.accessservice.domain.metasploit.AuthenResult;
import com.piggymetrics.accessservice.domain.metasploit.MetasploitConsole;
import com.piggymetrics.accessservice.domain.metasploit.MetasploitJobInfo;
import com.piggymetrics.accessservice.domain.metasploit.MetasploitModuleExecute;
import com.piggymetrics.accessservice.domain.metasploit.MetasploitModuleInfo;
import com.piggymetrics.accessservice.domain.metasploit.MetasploitProTaskLog;
import com.piggymetrics.accessservice.domain.metasploit.MetasploitSession;
import com.piggymetrics.accessservice.service.rpc.MetasploitRpc;
import com.piggymetrics.accessservice.util.MetasploitUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


/**
 * @author Kevin
 */
@RestController
@RequestMapping("/metasploit")
public class MetasploitController {
    @Autowired
    private MetasploitRpc rpc;

    @Autowired
    private Environment env;
    

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(Principal principle) throws Exception{
        System.out.println(principle.getName());
        Authen auth = new Authen();
        auth.setUser(env.getProperty("metasploit.user"));
        auth.setPass(env.getProperty("metasploit.pass"));
        auth.setSsl(false);

        String res = rpc.login(auth);
        return res;
    }

    @RequestMapping(path = "/module/execute", method = RequestMethod.POST)
    public String execute(Principal principle, @Valid @RequestBody MetasploitModuleExecute data) throws Exception{
        String res = rpc.moduleExecute(
            data.getToken(), 
            data.getModuleType(), 
            data.getModuleName(), 
            data.getHost(), 
            data.getPort()
        );
        return res;
    }

    @RequestMapping(path = "/module/info", method = RequestMethod.POST)
    public String moduleInfo(Principal principle, @Valid @RequestBody MetasploitModuleInfo data) throws Exception {
        String res = rpc.moduleInfo(
            data.getToken(),
            data.getModuleType(),
            data.getModuleName()
        );
        return res;
    }

    @RequestMapping(path = "/job/info", method = RequestMethod.POST)
    public String jobInfo(Principal principle, @Valid @RequestBody MetasploitJobInfo data) throws Exception {
        String res = rpc.jobInfo(data.getToken(), data.getJobID());
        return res;
    }

    @RequestMapping(path = "/pro/tasklog", method = RequestMethod.POST)
    public String proTaskLog(Principal principle, @Valid @RequestBody MetasploitProTaskLog data) throws Exception {
        String res = rpc.proTaskLog(data.getToken(), data.getJobID());
        return res;
    }

    @RequestMapping(path = "/session/list", method = RequestMethod.POST)
    public String sessionList(Principal principle, @Valid @RequestBody MetasploitSession data) throws Exception {
        String res = rpc.sessionList(data.getToken());
        return res;
    }

    @RequestMapping(path ="/session/shellread", method = RequestMethod.POST)
    public String sessionShellRead(Principal principle, @Valid @RequestBody MetasploitSession data) throws Exception {
        String res = rpc.sessionShellRead(data.getToken(), data.getSessionID());
        return res;
    }

    @RequestMapping(path ="/console/create", method = RequestMethod.POST)
    public String consoleCreate(Principal principle, @Valid @RequestBody MetasploitConsole data) throws Exception {
        String res = rpc.consoleCreate(data.getToken());
        return res;
    }

    @RequestMapping(path ="/console/list", method = RequestMethod.POST)
    public String consoleList(Principal principle, @Valid @RequestBody MetasploitConsole data) throws Exception {
        String res = rpc.consoleList(data.getToken());
        return res;
    }

    @RequestMapping(path ="/console/write", method = RequestMethod.POST)
    public String consoleWrite(Principal principle, @Valid @RequestBody MetasploitConsole data) throws Exception {
        String res = rpc.consoleWrite(data.getToken(), data.getConsoleID(), data.getConsoleCommand());
        return res;
    }

    @RequestMapping(path ="/console/read", method = RequestMethod.POST)
    public String consoleRead(Principal principle, @Valid @RequestBody MetasploitConsole data) throws Exception {
        String res = rpc.consoleRead(data.getToken(), data.getConsoleID());
        return res;
    }
}
