package com.piggymetrics.accessservice.domain.metasploit;

import java.util.UUID;

import org.springframework.data.redis.core.RedisHash;

/**
 * @author Kevin
 */

@RedisHash("Token")
public class Token {

    private UUID id = UUID.randomUUID();

    private String token;


    public Token(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Token{" +
            "id='" + id + '\'' +
            "token='" + token + '\'' +
            "}"; 
    }
}
