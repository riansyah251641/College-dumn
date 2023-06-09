--BAB 7 Procedure & Function 

-- pembeda adalah dari data yang dikembalikan 
-- prosedure tidak mengembalikan apapun (mirip void)
-- prosedure dapat menjalanlan suatu rumus sekaligus mirip void lhaaa

-- function mengembalian suatu nilai (sesuai dengan data yg dihasilkan)
-- mirip fungsi int,float,dll yang ada return nya

-- PROCEDURE


/* syntax
create [or replace] procedure procedure_name(parameter_list)
language plpgsql
as $$
declare
-- variable declaration
begin
-- stored procedure body
end; $$

jika ingin memanggil gunakan EXCECUTE/CALL
*/

drop table if exists accounts;

create table accounts (
    id int generated by default as identity,
    name varchar(100) not null,
    balance dec(15,2) not null,
    primary key(id)
);

insert into accounts(name,balance)
values('Bob',10000);

insert into accounts(name,balance)
values('Alice',10000);

-- melihat inputan pertama
select * from accounts;

-- run diatas duluuu

-- membuat fungsi procedure
create or replace procedure transfer(
   sender int,
   receiver int, 
   amount dec
)
language plpgsql    
as $$
DECLARE
	balance dec;
begin
    -- subtracting the amount from the sender's account 
    update accounts 
    set balance = balance - amount 
    where id = sender;

    -- adding the amount to the receiver's account
    update accounts 
    set balance = balance + amount 
    where id = receiver;
	
	-- select 
	SELECT * INTO balance FROM accounts;
	
	if (balance >= mount)then
	--something
	else
		RAISE EXCEPTION 'GAGAL';
	
	end if;

    commit;
end;$$

-- menggunakan fungsi procedure 
CALL transfer(1,2,10000);
-- kalau mau call langsung keluar table taruh fungsi select di fungsi call
-- kalau enggak di run sendiri" dari fungsi call dengan insert 


-- FUNCTION 
/* syntax
create [or replace] function function_name(param_list)
   returns return_type 
   language plpgsql
  as
$$
declare 
-- variable declaration
begin
 -- logic
end;
$$
*/

-- database diambil dari DVD Rental

-- fungsi mirip dengan procedure pembedanya ada di return nya
create function get_film_count(len_from int, len_to int)
returns int
language plpgsql
as
$$
declare
   film_count integer;
begin
   select count(*) 
   into film_count
   from film
   where length between len_from and len_to;
   return film_count;
end;
$$;

-- memangggil Fungsi 
select get_film_count(40,90);

