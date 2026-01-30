package com.cts.dto;

import java.time.LocalDateTime;

public class ServiceProgressUpdateRequest {
    private String status;
    private Integer progress;
    private String progressNotes;
    private Double timeSpent;
    private String issuesFound;
    private LocalDateTime estimatedCompletion;
    private String partsNeeded;
    private String agentId;

    // Getters and setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

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

    public String getAgentId() { return agentId; }
    public void setAgentId(String agentId) { this.agentId = agentId; }
}

