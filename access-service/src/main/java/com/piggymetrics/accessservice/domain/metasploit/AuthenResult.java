package com.piggymetrics.accessservice.domain.metasploit;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Kevin
 */
public class AuthenResult {
    public String result;
    
    public String token;

    public void setToken(String token) {
        this.token = token;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String response = mapper.writeValueAsString("{\"result\":\""+result+"\",\"token\":\""+token+"\"}");
            return response;
        } catch(IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
