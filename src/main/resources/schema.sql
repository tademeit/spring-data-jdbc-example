CREATE TABLE Customer (
    id     IDENTITY,
    name   VARCHAR(200),
    dob    DATE,
    gender VARCHAR(200)
);

CREATE TABLE Book (
    id      IDENTITY,
    title   VARCHAR(200)
);

CREATE TABLE Book_Author (
    book        INTEGER,
    author      INTEGER
);

CREATE TABLE Author (
    id      IDENTITY,
    name    VARCHAR(200)
)