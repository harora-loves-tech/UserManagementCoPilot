CREATE TABLE userinfo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL
);