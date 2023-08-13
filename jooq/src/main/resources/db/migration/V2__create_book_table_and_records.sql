-- V3__create_book_table_and_records.sql
CREATE TABLE library.book
(
    id        INT          NOT NULL,
    author_id INT          NOT NULL,
    title     VARCHAR(400) NOT NULL,

    CONSTRAINT pk_book PRIMARY KEY (id),
    CONSTRAINT fk_book_author_id FOREIGN KEY (author_id) REFERENCES library.author (id)
);


INSERT INTO library.author (first_name, last_name, date_of_birth, year_of_birth, address)
VALUES ('George', 'Orwell', '1903-06-25', 1903, null);

INSERT INTO library.author (first_name, last_name, date_of_birth, year_of_birth, address)
VALUES ('Paulo', 'Coelho', '1947-08-24', 1947, null);

INSERT INTO library.book
VALUES (1, 1, '1984');
INSERT INTO library.book
VALUES (2, 1, 'Animal Farm');
INSERT INTO library.book
VALUES (3, 2, 'O Alquimista');
INSERT INTO library.book
VALUES (4, 2, 'Brida');