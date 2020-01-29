package com.example.siriaco77.qpm.WS;

public class ObjectResponse {

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    boolean result;
    String message;
}
