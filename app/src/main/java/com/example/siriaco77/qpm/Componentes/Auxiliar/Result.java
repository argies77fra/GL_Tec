package com.example.siriaco77.qpm.Componentes.Auxiliar;

public class Result {
    String result;
    String message;

    public Result(String result, String message) {
        this.result = result;
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
