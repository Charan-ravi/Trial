package com.tryout.Runnerz;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
    public String getWelcomeMessage(){
        return "Hey there, This is my trial Spring Boot Application!";
    }
}