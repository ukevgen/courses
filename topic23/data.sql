USE hibernate;

CREATE TABLE books (
  id           INTEGER PRIMARY KEY AUTO_INCREMENT,
  book_name    VARCHAR(128) NOT NULL,
  author       VARCHAR(64)  NOT NULL,
  publish_date DATE         NOT NULL
);

CREATE TABLE book_shelves (
  id INTEGER PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE book_shelves_books (
  shelf_id INTEGER NOT NULL,
  book_id INTEGER NOT NULL
);