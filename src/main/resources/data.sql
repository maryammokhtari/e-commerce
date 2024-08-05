insert into category(name) values('vegetables');
insert into category(name) values('dairy');
insert into user_info(username, password, email, role) values('Maryam','Password','maryam.mokhtari.f@gmail.com','user');
insert into user_info(username, password, email, role) values('Hamed','Password1','rahmani@gmail.com','user');
insert into orders(order_date, total_amount, user_info_id) values('2024-08-05',26,1);
insert into orders(order_date, total_amount, user_info_id) values('2024-08-01',26,2);
insert into product(name, description,price, category_id) values('cucumber','green fruit',1,1);
insert into product(name, description,price, category_id) values('milk','white drink rich in protein',1.5,2);