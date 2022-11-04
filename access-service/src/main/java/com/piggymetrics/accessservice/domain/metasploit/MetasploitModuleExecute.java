package com.piggymetrics.accessservice.domain.metasploit;

public class MetasploitModuleExecute {
    private String token;

    private String moduleType;

    private String moduleName;
    
    private String host;

    private String port;

    public void setToken(String token) {
        this.token = token;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getToken() {
        return token;
    }

    public String getModuleType() {
        return moduleType;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }
}
