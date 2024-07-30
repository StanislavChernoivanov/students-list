CREATE SCHEMA IF NOT EXISTS students_schema;
CREATE TABLE IF NOT EXISTS students_schema.students
(
    id BIGINT PRIMARY KEY,
    firstName VARCHAR(255) NOT NULL,
    lastName VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL
   )