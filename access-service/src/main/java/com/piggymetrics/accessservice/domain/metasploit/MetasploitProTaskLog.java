package com.piggymetrics.accessservice.domain.metasploit;

public class MetasploitProTaskLog {
    
    private String token;

    private String jobID;

    public void setToken(String token) {
        this.token = token;
    }

    public void setJobID(String id) {
        this.jobID = id;
    }

    public String getToken() {
        return token;
    }

    public String getJobID() {
        return jobID;
    }
}
