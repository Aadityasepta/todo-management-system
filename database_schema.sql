-- Database Creation
CREATE DATABASE IF NOT EXISTS todo_management_db;
USE todo_management_db;

-- Users Table
CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL DEFAULT 'ROLE_USER',
    INDEX idx_username (username),
    INDEX idx_email (email)
);

-- Tasks Table
CREATE TABLE IF NOT EXISTS tasks (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    reminder_date DATETIME,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    INDEX idx_user_id (user_id),
    INDEX idx_status (status),
    INDEX idx_reminder_date (reminder_date)
);

-- Sample Data (Optional - for testing)
-- Insert sample user (password: password123)
-- INSERT INTO users (username, email, password, role) 
-- VALUES ('testuser', 'test@example.com', '$2a$10$xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx', 'ROLE_USER');

-- Insert sample tasks
-- INSERT INTO tasks (title, description, status, user_id) 
-- VALUES ('Complete project documentation', 'Write comprehensive documentation for the project', 'PENDING', 1);

-- INSERT INTO tasks (title, description, status, user_id) 
-- VALUES ('Review code', 'Review and approve pull requests', 'DONE', 1);
