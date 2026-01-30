-- SQL script to create the assigned_services table
-- This table tracks which service is assigned to which service agent

CREATE TABLE IF NOT EXISTS assigned_services (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    service_request_id BIGINT NOT NULL,
    agent_id VARCHAR(255) NOT NULL,
    vehicle_id BIGINT NOT NULL,
    customer_id VARCHAR(255) NOT NULL,
    service_type VARCHAR(255) NOT NULL,
    status VARCHAR(50) DEFAULT 'assigned',
    assigned_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    accepted_date TIMESTAMP NULL,
    priority VARCHAR(50),
    admin_instruction TEXT,
    instruction_date TIMESTAMP NULL,
    progress INT,
    progress_notes TEXT,
    time_spent DOUBLE,
    issues_found TEXT,
    estimated_completion TIMESTAMP NULL,
    parts_needed TEXT,
    last_update TIMESTAMP NULL,

    -- Indexes for better performance
    INDEX idx_agent_id (agent_id),
    INDEX idx_service_request_id (service_request_id),
    INDEX idx_status (status),
    INDEX idx_assigned_date (assigned_date),

    -- Foreign key constraints (uncomment if you have the referenced tables)
    -- FOREIGN KEY (service_request_id) REFERENCES service_records(id),
    -- FOREIGN KEY (agent_id) REFERENCES service_agents(user_id),
    -- FOREIGN KEY (vehicle_id) REFERENCES vehicles(id),
    -- FOREIGN KEY (customer_id) REFERENCES customers(id)
);

-- Insert sample data (optional - for testing)
-- INSERT INTO assigned_services (service_request_id, agent_id, vehicle_id, customer_id, service_type, status, priority) VALUES
-- (1, 'agent001', 1001, 'cust001', 'Oil Change', 'assigned', 'high'),
-- (2, 'agent002', 1002, 'cust002', 'Brake Repair', 'accepted', 'medium'),
-- (3, 'agent001', 1003, 'cust003', 'Tire Replacement', 'in_progress', 'low');
