-- V2__create_author_table.sql
CREATE TABLE library.author
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    first_name    VARCHAR(50),
    last_name     VARCHAR(50) NOT NULL,
    date_of_birth DATE,
    year_of_birth INT,
    address       VARCHAR(50)
);