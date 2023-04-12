-- BAB 6 PostgreSQL ViewURL
-- guna untuk memudahkan user lain dalam mengases database
-- menghold hasil select query yang telah kita lakukan dan dapat digunakan kembali oleh user dengan kode yang lebih singkat
-- terdapat fungsi CRUD juga pada view
-- tabel virtual yang berisi hasil query


-- table adress, city, dan country blm dibuat
-- sehingga tidak dapat dirun 
 SELECT cu.customer_id AS id,
    cu.first_name || ' ' || cu.last_name AS name,
    a.address,
    a.postal_code AS "zip code",
    a.phone,
    city.city,
    country.country,
        CASE
            WHEN cu.activebool THEN 'active'
            ELSE ''
        END AS notes,
    cu.store_id AS sid
   FROM customers cu
     INNER JOIN address a USING (address_id)
     INNER JOIN city USING (city_id)
     INNER JOIN country USING (country_id);
	 
-- KEDUA
CREATE OR REPLACE VIEW customer_master AS
  SELECT cu.customer_id AS id,
    cu.first_name || ' ' || cu.last_name AS name,
    a.address,
    a.postal_code AS "zip code",
    a.phone,
    city.city,
    country.country,
        CASE
            WHEN cu.activebool THEN 'active'
            ELSE ''
        END AS notes,
    cu.store_id AS sid
   FROM customers cu
     INNER JOIN address a USING (address_id)
     INNER JOIN city USING (city_id)
     INNER JOIN country USING (country_id);
	 
SELECT * FROM customes_master;