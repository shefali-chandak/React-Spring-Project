package com.jwt.payload;

public class ApiResponse {
    private Object data = null;
    private String error = null;

    public ApiResponse(Object data, String error) {
        this.data = data;
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}