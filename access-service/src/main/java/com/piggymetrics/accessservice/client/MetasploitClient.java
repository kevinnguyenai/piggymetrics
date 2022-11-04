package com.piggymetrics.accessservice.client;

import com.piggymetrics.accessservice.domain.metasploit.Authen;
import com.piggymetrics.accessservice.domain.metasploit.AuthenResult;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;


/**
 * @author Kevin
 */

// msfrpcd login 
@FeignClient(url = "${metasploit.url}", name = "metasploit-client")
public interface MetasploitClient {
    @PostMapping(value = "${metasploit.uri}", headers = {"content-type=binary/message-pack"})
    byte[] login(@RequestBody byte[] auth);

    @PostMapping(value = "${metasploit.uri}", headers = {"content-type=binary/message-pack"})
    byte[] execute(@RequestBody byte[] data);
}
