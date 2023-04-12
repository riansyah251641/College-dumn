-- BAB 1 Primary Key (Muhammad febriansyah -502521164)
-- tutorial pembuatan tabel dengan setting primary key
CREATE TABLE po_items (
	po_no INTEGER,
	item_no INTEGER,
	product_no INTEGER,
	qty INTEGER,
	net_price NUMERIC,
	PRIMARY KEY (po_no, item_no)
);

CREATE TABLE products (
	product_no INTEGER,
	description TEXT,
	product_cost NUMERIC
);

-- dapat juga dilakukan penambahan kolom, primary key pada tabel dengan ALTER TABLE
ALTER TABLE products 
ADD PRIMARY KEY (product_no);

CREATE TABLE vendors (name VARCHAR(255));
-- memasukkan data de dalam table
INSERT INTO vendors (NAME)
VALUES
	('Microsoft'),
	('IBM'),
	('Apple'),
	('Samsung');

-- Melihat input yang dimasukkan
SELECT * FROM vendors;

-- penggunakan alter dengan penambahan kolom atau penghapusan kolom
ALTER TABLE vendors ADD COLUMN ID SERIAL PRIMARY KEY;
ALTER TABLE products
DROP CONSTRAINT products_pkey;

