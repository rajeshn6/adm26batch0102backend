
package com.cts.dto;

public class ApiResponse {
    private String status;
    private String message;
    private String data;
    private Long userId;

    public ApiResponse() {}

    public ApiResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ApiResponse(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = (String) data;
    }

    public ApiResponse(String status, String message, Long userId) {
        this.status = status;
        this.message = message;
        this.userId = userId;
    }

    // getters/setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Object getData() { return data; }
    public void setData(Object data) { this.data = (String) data; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
