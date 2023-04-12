-- BAB 3 CHECK Constraint (muhammad febriansyah-5025211164)

-- membuat tabel baru dari employees
DROP TABLE IF EXISTS employees;
CREATE TABLE employees (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR (50),
	last_name VARCHAR (50),
	birth_date DATE CHECK (birth_date > '1900-01-01'),
	joined_date DATE CHECK (joined_date > birth_date),
	salary numeric CHECK(salary > 0)
);

-- melakukan insert pada tabel namum error karena ada nya input yang dimasukkan tidak sesuai dengan input colom pada check
-- yakni di colomn salary yang bernilai negatif , harusnya bernilai positif
INSERT INTO employees (first_name, last_name, birth_date, joined_date, salary)
VALUES ('John', 'Doe', '1972-01-01', '2015-07-01', - 100000);


-- membuat table baru
CREATE TABLE prices_list (
	id serial PRIMARY KEY,
	product_id INT NOT NULL,
	price NUMERIC NOT NULL,
	discount NUMERIC NOT NULL,
	valid_from DATE NOT NULL,
	valid_to DATE NOT NULL
);

-- menambahkan check dengan ALTER TABLE
ALTER TABLE prices_list 
ADD CONSTRAINT price_discount_check 
CHECK (
	price > 0
	AND discount >= 0
	AND price > discount
);

-- menambahkan kembali
ALTER TABLE prices_list 
ADD CONSTRAINT valid_range_check 
CHECK (valid_to >= valid_from);

--melakukan uji coba insert pada table prices_list yang benar
INSERT INTO prices_list  (product_id,price,discount,valid_from, valid_to) 
Values (102,50000,5000,'2023-03-11','2023-03-12');

-- melakukan uji cova insert yang salah
INSERT INTO prices_list  (product_id,price,discount,valid_from, valid_to) 
Values (102,50000,70000,'2023-03-11','2023-03-12');