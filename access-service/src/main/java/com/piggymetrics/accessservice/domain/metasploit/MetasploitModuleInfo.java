package com.piggymetrics.accessservice.domain.metasploit;

public class MetasploitModuleInfo {
    private String token;

    private String moduleType;

    private String moduleName;
    

    public void setToken(String token) {
        this.token = token;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
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
}
