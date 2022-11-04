package com.piggymetrics.accessservice.service.rpc;

import java.io.IOException;

import com.piggymetrics.accessservice.domain.metasploit.Authen;
import com.piggymetrics.accessservice.domain.metasploit.AuthenResult;


/**
 * @author Kevin
 */
public interface MetasploitRpc {
    
    /**
     *  msfrpcd login
     * @param "auth.login" => command
     * @param auth => is Authen object
     */
    String login(Authen auth) throws IOException;

    /**
     * msfrpcd Module Execute
     * @param "module.execute" => command
     * @param token => login token
     * @param moduleType
     * @param moduleName
     * @param host => RHOST
     * @param port => RPORT
     */
    String moduleExecute(String token, String moduleType, String moduleName, String host, String port) throws IOException;

    /**
     * msfrpcd Module Info
     * @param "module.info" => command
     * @param token => login token
     * @param moduleType
     * @param moduleName
     */
    String moduleInfo(String token, String moduleType, String moduleName) throws IOException;

    /**
     * msfrpcd Job Info
     * @param "job.info" => command
     * @param token => login token
     * @param jobID => ID of job
     */
    String jobInfo(String token, String jobID) throws IOException;

    /**
     * msfrpcd pro Task Log
     * @param "pro.task_log" => command
     * @param token => login token
     * @param jobID => ID of Job
     */
    String proTaskLog(String token, String jobID) throws IOException;

    /**
     * msfrpcd session list
     * @param "session.list" => command
     * @param token
     */
    String sessionList(String token) throws IOException;


    /**
     * msfrpcd session shell_read
     * @param "session.shell_read" => command
     * @param token => token
     * @param session => ID
     */
    String sessionShellRead(String token, String sessionID) throws IOException;

    /**
     * msfrpcd console create
     * @param "console.create" => command
     * @param token
     */
    String consoleCreate(String token) throws IOException;

    /**
     * msfrpcd console list
     * @param "console.list" => command
     * @param token
     */
    String consoleList(String token) throws IOException;

    /**
     * msfrpcd console write
     * @param "console.write" => command
     * @param token
     * @param consoleID
     * @param consoleCommand
     */
    String consoleWrite(String token, String consoleID, String consoleCommand) throws IOException;

    /**
     * msfrpcd console.read
     * @param "console.read" => command
     * @param token
     * @param consoleID
     */
    String consoleRead(String token, String consoleID) throws IOException;
}
