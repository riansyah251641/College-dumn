--BAB 5 Not-Null Constraint (muhammad febrianysyah)
-- Dilakukan agar input pada suatu kolom tidak ada yang bernilai null saat data dimasukkan

-- membuat table invoice
CREATE TABLE invoices(
  id SERIAL PRIMARY KEY,
  product_id INT NOT NULL,
  qty numeric NOT NULL CHECK(qty > 0),
  net_price numeric CHECK(net_price > 0) 
);


-- melakukan insert yang bernilai BENAR
INSERT INTO invoices(product_id, qty, net_price) VALUES (12,1,100000);

-- melakukan insert yang bernilai nULL pada qty (SALAH)
INSERT INTO invoices (product_id, net_price) VALUES (12,100000);

