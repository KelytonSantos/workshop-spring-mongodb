package com.lucasantos.workshopmongo.resources.exception;

import java.io.Serializable;

public class StandarError implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long timesatamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandarError(){
    }

    public StandarError(Long timesatamp, Integer status, String error, String message, String path) {
        this.timesatamp = timesatamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getTimesatamp() {
        return timesatamp;
    }

    public void setTimesatamp(Long timesatamp) {
        this.timesatamp = timesatamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }  
}