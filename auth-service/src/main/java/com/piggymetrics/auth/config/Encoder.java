package com.piggymetrics.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Encoder {

    @Bean
    public PasswordEncoder passwordEncoder() {
        String idForEncode = "bcrypt";
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(idForEncode, new BCryptPasswordEncoder());
        DelegatingPasswordEncoder delegatingEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);

        return delegatingEncoder;
    }

}
