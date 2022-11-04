package com.piggymetrics.accessservice.util;

import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;
import org.msgpack.core.buffer.MessageBufferInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.msgpack.core.MessageBufferPacker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.piggymetrics.accessservice.domain.metasploit.AuthenResult;


/**
 * @author Kevin
 */
@Component
public class MetasploitUtil {

    String meth;
    String[] args;

    private static final Logger log = LoggerFactory.getLogger(MetasploitUtil.class);

    private MetasploitUtil() {}

    public MetasploitUtil(String meth, String[] args) {
        this.meth = meth;
        this.args = args;
    }

    public byte[] encode(String meth, ArrayList<String> args) throws IOException {
        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();
        ArrayList<String> arr = new ArrayList<String>();
        arr.add(meth);
        for(String v: args) {
            arr.add(v);
        }
        packer.packArrayHeader(arr.toArray().length);
        for(String j: arr) {
            packer.packString(j);
        }
        packer.close();
        byte[] packerData = packer.toByteArray();
        return packerData;
    }

    public byte[] customMetasploitModuleExecutorEncode(String meth, ArrayList<String> args, String host, String port) throws IOException {
        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();
        ArrayList<Object> arr = new ArrayList<Object>();
        arr.add(meth);
        for(String v: args) {
            arr.add(v);
        }
        Map<String, String> options = new HashMap<String, String>();
        options.putIfAbsent("RHOST", host);
        options.putIfAbsent("RPORT", port);
        arr.add(options);
        log.info("ENCODE MSGPACK {}", arr);
        packer.packArrayHeader(arr.toArray().length);
        for(Object j: arr) {
            log.info(j.toString());
            packer.packString(j.toString());
        }
        packer.close();
        byte[] packerData = packer.toByteArray();
        return packerData;
    }

    public byte[] customMetasploitModuleInfoEncode(String meth, ArrayList<String> args) throws IOException {
        MessageBufferPacker packer = MessagePack.newDefaultBufferPacker();
        ArrayList<String> arr = new ArrayList<String>();
        arr.add(meth);
        for(String v: args) {
            arr.add(v);
        }
        log.info("ENCODE MSGPACK {}", arr);
        packer.packArrayHeader(arr.toArray().length);
        for(String j: arr) {
            packer.packString(j);
        }
        packer.close();
        byte[] packerData = packer.toByteArray();
        return packerData;
    }

    public AuthenResult decodeAuthenResult(byte[] args) throws IOException{
        MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(args);
        Integer Result1 = unpacker.unpackMapHeader();
        log.info("OBJECT MAP is {}", Result1);
        Map<String, String> result = new HashMap<String, String>();
        result.putIfAbsent(unpacker.unpackString(), unpacker.unpackString());
        result.putIfAbsent(unpacker.unpackString(), unpacker.unpackString());
        //log.info("OBJECT {}  HAVE {}={} ,{}={}", Result1, key1,value1,key2,value2);
        
        // Json parsing
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(result);
        AuthenResult authenresult = mapper.readValue(jsonString, AuthenResult.class);
        //mapper.writeValue(new File("/tmp/login.json"), args);
        
        return authenresult;
    }

    public String decodeExecutor(byte[] args) throws IOException {
        MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(args);
        Integer loop = unpacker.unpackMapHeader();
        log.info("LOOP DATA = {}", loop);
        Map<String, String> result = new HashMap<String, String>();
        try {
            for(Integer i = 0; i < loop/2; i++) {
                result.putIfAbsent(unpacker.unpackString(), unpacker.unpackString());
            } 
        } catch(IOException ex) {
            ex.printStackTrace();
            /*
             String keyErr = unpacker.unpackString();
             Boolean valueErr = unpacker.unpackBoolean();
             result.putIfAbsent(keyErr, valueErr.toString());
             for(Integer i = 1; i < loop/2; i++) {
                result.putIfAbsent(unpacker.unpackString(), unpacker.unpackString());
             }
             ObjectMapper mapper = new ObjectMapper();
             String errString = mapper.writeValueAsString(result);
             */

        }
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(result);
        return jsonString;
    }

}
