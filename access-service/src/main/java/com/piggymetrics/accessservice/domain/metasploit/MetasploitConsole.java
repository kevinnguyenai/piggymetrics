package com.piggymetrics.accessservice.domain.metasploit;

public class MetasploitConsole {

    private String token;

    private String consoleID;

    private String consoleCommand;

    public void setToken(String token) {
        this.token = token;
    }

    public void setConsoleID(String consoleID) {
        this.consoleID = consoleID;
    }

    public void setConsoleCommand(String command) {
        this.consoleCommand = command;
    }

    public String getToken() {
        return token;
    }

    public String getConsoleID() {
        return consoleID;
    }

    public String getConsoleCommand() {
        return consoleCommand;
    }
    
}
