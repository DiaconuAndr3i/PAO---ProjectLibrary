package com.springboot.system.Library.error.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFound extends Exception{
    NotFound(String message){
        super(message);
    }
}
