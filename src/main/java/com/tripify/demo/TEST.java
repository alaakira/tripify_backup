package com.tripify.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class TEST extends UsernamePasswordAuthenticationFilter {
    public static void main(String[] args){

        String cr = new BCryptPasswordEncoder().encode("123456");
        String cr2 = new BCryptPasswordEncoder().encode("123456");
        System.out.println(new BCryptPasswordEncoder().matches("123456",cr));
    }
}
