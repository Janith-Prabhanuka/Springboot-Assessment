package com.assignment.Assignment.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseWrapper {

    private String message;
    private String error;
    private List<Object> data;
    private int status;


    public ResponseWrapper(int status, Object Dto,String message) {
        try {
            this.data = new ArrayList<>();
            for (Object to : (ArrayList) Dto) {
                data.add(to);
            }}catch(Exception e){
            data.add(Dto);
        }
        this.status = status;
        this.message = message;
    }

    public ResponseWrapper(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
