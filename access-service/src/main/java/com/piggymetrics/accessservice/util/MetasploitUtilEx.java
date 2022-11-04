package com.piggymetrics.accessservice.util;

import org.msgpack.MessagePack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author Kevin
 */
@Component
public class MetasploitUtilEx {
    
    private static final Logger log = LoggerFactory.getLogger(MetasploitUtil.class);

    protected static MessagePack messagePack;
 
    static {
        messagePack = new MessagePack();
    }

    public byte[] extendMetasploitModuleExecutorEncode(String meth, ArrayList<String> args, String host, String port) throws IOException {
        MessagePack packer = new MessagePack();
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
        return packer.write(arr);
    }

    public byte[] extendMetasploitEncode(String meth, ArrayList<String> args) throws IOException {
        MessagePack packer = new MessagePack();
        ArrayList<Object> arr = new ArrayList<Object>();
        arr.add(meth);
        for(String v: args) {
            arr.add(v);
        }
        log.info("ENCODE MSGPACK {}", arr);
        return packer.write(arr);
    }

    public String decodeExecutor(byte[] args) throws IOException {
        MessagePack unpacker = new MessagePack();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(unpacker.read(args));
        return jsonString;
    }

    public String decodeConsole(byte[] args) throws IOException {
        MessagePack unpacker = new MessagePack();
        Object jsonString = unpacker.read(args);
        return jsonString.toString();
    }

}
