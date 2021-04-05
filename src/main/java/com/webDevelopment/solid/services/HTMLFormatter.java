package com.webDevelopment.solid.services;

import org.springframework.stereotype.Service;

@Service
public class HTMLFormatter implements Formatter{

    @Override
    public String Format(String message) {
        return "<p>" + message.replaceAll("(\r?\n)","<br>") + "</p>";
    }
}
