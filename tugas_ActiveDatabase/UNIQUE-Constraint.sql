-- BAB 4 UNIQUE Constraint (muhammad febriansyah-5025211164)
-- dilakukan agar data pada suatu kolom tidak ada yang sama nilainya dari semua entitas

-- membuat table person
CREATE TABLE person (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR (50),
	last_name VARCHAR (50),
	email VARCHAR (50) UNIQUE
);

-- dimasukkan data pertama
INSERT INTO person(first_name,last_name,email)
VALUES('john','doe','j.doe@postgresqltutorial.com');

--dimasukkan data kedua yang memiliki nilai email yang sama dengan sebelummnya
INSERT INTO person(first_name,last_name,email)
VALUES('jack','doe','j.doe@postgresqltutorial.com');

-- terjadi eror pada insert kedua