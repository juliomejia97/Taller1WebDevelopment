package com.webDevelopment.solid.services;

import org.springframework.stereotype.Service;

public class JsonFormatter implements Formatter {
    @Override
    public String Format(String message) {
        return "{\"message\": \"" + message + "\"}";
    }
}
