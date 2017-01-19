CREATE DATABASE movies_db;
USE movies_db;
CREATE TABLE genre (
genre_id INT AUTO_INCREMENT PRIMARY KEY,
genre VARCHAR(20) NOT NULL
);
CREATE TABLE movies (
movie_id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
year YEAR,
country VARCHAR(20)
);
CREATE TABLE movies_genre (
movie_id INT NOT NULL,
genre_id INT NOT NULL,
PRIMARY KEY (movie_id, genre_id),
FOREIGN KEY (movie_id) REFERENCES movies (movie_id),
FOREIGN KEY (genre_id) REFERENCES genre (genre_id)
);
CREATE TABLE castMembers (
cm_id INT AUTO_INCREMENT PRIMARY KEY,
fname VARCHAR(20) NOT NULL,
lname VARCHAR(20) NOT NULL,
mname VARCHAR(30),
dateOfBirth DATE
);
CREATE TABLE movies_members (
movie_id INT NOT NULL,
cm_id INT NOT NULL,
memberType VARCHAR(20) NOT NULL,
PRIMARY KEY (movie_id, cm_id),
FOREIGN KEY (movie_id) REFERENCES movies (movie_id),
FOREIGN KEY (cm_id) REFERENCES castMembers (cm_id)
);
CREATE TABLE users (
user_id INT AUTO_INCREMENT PRIMARY KEY,
fname VARCHAR(20) NOT NULL,
lname VARCHAR(20),
mname VARCHAR(30),
email VARCHAR(30) NOT NULL,
password VARCHAR(20) NOT NULL
);
CREATE TABLE reviews (
review_id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT NOT NULL,
movie_id INT NOT NULL,
rank INT NOT NULL,
comment TEXT,
FOREIGN KEY (user_id) REFERENCES users (user_id),
FOREIGN KEY (movie_id) REFERENCES movies (movie_id)
);
SHOW TABLES;