package com.piggymetrics.accessservice.domain.metasploit;

public class MetasploitSession {
    
    private String token;

    private String sessionID;

    public void setToken(String token) {
        this.token = token;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getToken() {
        return token;
    }

    public String getSessionID() {
        return sessionID;
    }
}
