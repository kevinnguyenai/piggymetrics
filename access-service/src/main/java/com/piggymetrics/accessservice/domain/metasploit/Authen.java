package com.piggymetrics.accessservice.domain.metasploit;

/**
 * @author Kevin
 */
public class Authen {
    
    private String user;

    private String pass;

    private Boolean ssl = true;

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setSsl(Boolean ssl) {
        this.ssl = ssl;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public Boolean getSsl() {
        return ssl;
    }

    @Override
    public String toString() {
        return "Authen{" +
            "user='" + user + '\'' +
            "pass='" + pass + '\'' +
            "ssl='" + ssl + '\'' +
            "}";
    }
}
