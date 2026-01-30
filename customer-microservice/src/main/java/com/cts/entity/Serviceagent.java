
package com.cts.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "service_agent",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_service_agent_email", columnNames = "email"),
        @UniqueConstraint(name = "uk_service_agent_user_id", columnNames = "user_id")
    }
)
public class Serviceagent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id", nullable=false, length=64)
    private String userId;

    @Column(name="name", nullable=false, length=128)
    private String name;

    @Column(name="email", nullable=false, length=180)
    private String email;

    @Column(name="password_hash", nullable=false, length=200)
    private String passwordHash;

    @Column(name="secret_code", length=64)
    private String secretCode; // stored for audit/traceability (optional)

    @CreationTimestamp
    @Column(name="created_at", updatable=false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    // getters/setters
    public Long getId() { return id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public String getSecretCode() { return secretCode; }
    public void setSecretCode(String secretCode) { this.secretCode = secretCode; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
