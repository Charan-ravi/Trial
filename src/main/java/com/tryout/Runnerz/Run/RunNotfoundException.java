package com.tryout.Runnerz.Run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RunNotfoundException extends RuntimeException{
    public RunNotfoundException(){
        super("Run not found");
    }
}
