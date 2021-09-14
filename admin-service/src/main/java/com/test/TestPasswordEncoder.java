package com.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class TestPasswordEncoder {
    
    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String encoded = encoder.encode("ROOT");
        //$2a$10$Rb.h.AJsWPcRbLueoh6m2.iTxWmNDE5/7bXH8QIf.p2MoLt3jqYgm
        System.out.println(encoded);

        System.out.println(encoder.matches("abc", encoded));
        System.out.println(encoder.matches("demo@123", encoded));
        System.out.println(encoder.matches("demo#124", encoded));
        System.out.println(encoder.matches("ROOT", encoded));

    }

}