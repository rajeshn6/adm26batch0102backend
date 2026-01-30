package com.cts.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "assigned_services")
public class AssignedService {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "service_request_id")
    private Long serviceRequestId;
    
    @Column(name = "agent_id")
    private String agentId;
    
    @Column(name = "vehicle_id")
    private Long vehicleId;
    
    @Column(name = "customer_id")
    private String customerId;
    
    @Column(name = "service_type")
    private String serviceType;
    
    @Column(name = "status")
    private String status = "assigned";
    
    @Column(name = "assigned_date")
    private LocalDateTime assignedDate;
    
    @Column(name = "accepted_date")
    private LocalDateTime acceptedDate;
    
    @Column(name = "priority")
    private String priority;

    @Column(name = "admin_instruction", columnDefinition = "TEXT")
    private String adminInstruction;

    @Column(name = "instruction_date")
    private LocalDateTime instructionDate;

    @Column(name = "progress")
    private Integer progress;

    @Column(name = "progress_notes", columnDefinition = "TEXT")
    private String progressNotes;

    @Column(name = "time_spent")
    private Double timeSpent;

    @Column(name = "issues_found", columnDefinition = "TEXT")
    private String issuesFound;

    @Column(name = "estimated_completion")
    private LocalDateTime estimatedCompletion;

    @Column(name = "parts_needed", columnDefinition = "TEXT")
    private String partsNeeded;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    public AssignedService() {
        this.assignedDate = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getServiceRequestId() { return serviceRequestId; }
    public void setServiceRequestId(Long serviceRequestId) { this.serviceRequestId = serviceRequestId; }

    public String getAgentId() { return agentId; }
    public void setAgentId(String agentId) { this.agentId = agentId; }

    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getAssignedDate() { return assignedDate; }
    public void setAssignedDate(LocalDateTime assignedDate) { this.assignedDate = assignedDate; }

    public LocalDateTime getAcceptedDate() { return acceptedDate; }
    public void setAcceptedDate(LocalDateTime acceptedDate) { this.acceptedDate = acceptedDate; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getAdminInstruction() { return adminInstruction; }
    public void setAdminInstruction(String adminInstruction) { this.adminInstruction = adminInstruction; }

    public LocalDateTime getInstructionDate() { return instructionDate; }
    public void setInstructionDate(LocalDateTime instructionDate) { this.instructionDate = instructionDate; }

    public LocalDateTime getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(LocalDateTime lastUpdate) { this.lastUpdate = lastUpdate; }

    public Integer getProgress() { return progress; }
    public void setProgress(Integer progress) { this.progress = progress; }

    public String getProgressNotes() { return progressNotes; }
    public void setProgressNotes(String progressNotes) { this.progressNotes = progressNotes; }

    public Double getTimeSpent() { return timeSpent; }
    public void setTimeSpent(Double timeSpent) { this.timeSpent = timeSpent; }

    public String getIssuesFound() { return issuesFound; }
    public void setIssuesFound(String issuesFound) { this.issuesFound = issuesFound; }

    public LocalDateTime getEstimatedCompletion() { return estimatedCompletion; }
    public void setEstimatedCompletion(LocalDateTime estimatedCompletion) { this.estimatedCompletion = estimatedCompletion; }

    public String getPartsNeeded() { return partsNeeded; }
    public void setPartsNeeded(String partsNeeded) { this.partsNeeded = partsNeeded; }
}
