#USE movies_db;

SELECT * FROM genre;
SELECT * FROM movies;
SELECT * FROM movies_genre;
SELECT * FROM castmembers;
SELECT * FROM movies_members;
SELECT * FROM users;
SELECT * FROM reviews;
SELECT name AS Фильм, year AS Год, country AS Страна FROM movies WHERE year = '2003';
SELECT name AS Фильм, year AS Год, country AS Страна FROM movies;

SELECT fname, lname, date_of_birth FROM castmembers WHERE cm_id IN (SELECT cm_id FROM movies_members WHERE movie_id = 
(SELECT movie_id FROM movies WHERE name = 'Хоббит: Нежданное путешествие'));

SELECT comment FROM reviews WHERE movie_id = (SELECT movie_id FROM movies WHERE name = 'Хоббит: Нежданное путешествие');

SELECT name FROM movies WHERE movie_id IN (SELECT movie_id FROM movies_members WHERE cm_id = 
(SELECT cm_id FROM castmembers WHERE fname = 'Джонни' AND lname = 'Депп'));

SELECT name FROM movies WHERE movie_id IN (SELECT movie_id FROM movies_members WHERE cm_id = 
(SELECT cm_id FROM castmembers WHERE fname = 'Орландо' AND lname = 'Блум'));

SELECT comment FROM reviews WHERE user_id IN (SELECT user_id FROM users WHERE fname = 'Дмитрий' AND lname = 'Нестерчук');

SELECT m.name AS Фильм, m.year AS Год, m.country AS Страна, g.genre AS Жанр FROM movies AS m INNER JOIN movies_genre AS mg 
ON m.movie_id = mg.movie_id JOIN genre AS g ON mg.genre_id = g.genre_id;

SELECT c.fname AS Имя, c.lname AS Фамилия, c.date_of_birth AS Дата_рождения, m.name AS Фильм FROM castmembers AS c 
INNER JOIN movies_members AS mm ON c.cm_id = mm.cm_id JOIN movies AS m ON mm.movie_id = m.movie_id;

SELECT c.fname AS Имя, c.lname AS Фамилия, c.date_of_birth AS Дата_рождения, mm.member_type AS Профессия FROM castmembers AS c 
INNER JOIN movies_members AS mm ON c.cm_id = mm.cm_id JOIN movies AS m ON mm.movie_id = m.movie_id 
WHERE m.name = 'Хоббит: Нежданное путешествие';

SELECT m.name AS Фильм FROM movies AS m INNER JOIN movies_members AS mm ON m.movie_id = mm.movie_id 
JOIN castmembers AS c ON mm.cm_id = c.cm_id WHERE c.fname = 'Джонни' AND c.lname = 'Депп';

SELECT u.fname AS Имя, u.lname AS Фамилия, r.comment AS Комментарий FROM users AS u INNER JOIN reviews AS r ON u.user_id = r.user_id;

SELECT u.fname AS Имя, u.lname AS Фамилия, r.comment AS Комментарий FROM users AS u INNER JOIN reviews AS r ON u.user_id = r.user_id 
WHERE u.fname = 'Дмитрий' AND u.lname = 'Нестерчук';

SELECT r.rank AS Оценка, r.comment AS Комментарий FROM reviews AS r INNER JOIN movies AS m ON r.movie_id = m.movie_id;

SELECT r.rank AS Оценка, r.comment AS Комментарий FROM reviews AS r INNER JOIN movies AS m ON r.movie_id = m.movie_id 
WHERE m.name = 'Властелин колец: Братство кольца';
