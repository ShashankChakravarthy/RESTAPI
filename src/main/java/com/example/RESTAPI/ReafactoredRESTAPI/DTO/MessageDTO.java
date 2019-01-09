package com.example.RESTAPI.ReafactoredRESTAPI.DTO;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component

public class MessageDTO {

    private String message;
    private String type;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
