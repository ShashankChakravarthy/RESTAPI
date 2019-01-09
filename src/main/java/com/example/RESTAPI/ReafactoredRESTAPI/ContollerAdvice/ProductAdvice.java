package com.example.RESTAPI.ReafactoredRESTAPI.ContollerAdvice;

import com.example.RESTAPI.ReafactoredRESTAPI.DTO.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAdvice {

    @Autowired
    private MessageDTO messageDTO;

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDTO processNullPointerException(NullPointerException e){
        messageDTO.setMessage("We have a Null pointer Exception");
        messageDTO.setType("Null Pointer");
        return messageDTO;
    }

}
