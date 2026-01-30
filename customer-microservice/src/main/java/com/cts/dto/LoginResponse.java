package com.cts.dto;

public class LoginResponse {
    private String status;
    private String message;
    private String userId;
    private String name;
    private String role;
    private String token;
    private String createdAt;

    public LoginResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public LoginResponse(String status, String message, String userId, String name, String role, String token) {
        this.status = status;
        this.message = message;
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.token = token;
    }

    public LoginResponse(String status, String message, String userId, String name, String role, String token, String createdAt) {
        this.status = status;
        this.message = message;
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.token = token;
        this.createdAt = createdAt;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
