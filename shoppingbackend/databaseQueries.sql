Create table category(
  id IDENTITY,
  name VARCHAR(30),
  description VARCHAR(150),
  image_url VARCHAR(60),
  is_active BOOLEAN,
  CONSTRAINT pk_categrory_id PRIMARY KEY(id)
);

INSERT INTO category(name,description,image_url,is_active) VALUES('Fan','This is description for Fan Category!','CAT_7.png',true);


CREATE TABLE user_detail (
 id IDENTITY,
 first_name VARCHAR(15),
 last_name VARCHAR(15),
 role VARCHAR(20),
 enable BOOLEAN,
 password VARCHAR(30),
 email VARCHAR(40),
 contact_number VARCHAR2(15),
 CONSTRAINT pk_user_id PRIMARY KEY(id)
);

INSERT INTO user_detail
(first_name,last_name,role,enable,password,email,contact_number) 
VALUES('Virat','Kohli','ADMIN',true,'admin','vk@gmail.com','8888888888');

INSERT INTO user_detail
(first_name,last_name,role,enable,password,email,contact_number) 
VALUES('Ravindra','Jadeja','SUPPLIER',true,'12345','rj@gmail.com','7778888888');

INSERT INTO user_detail
(first_name,last_name,role,enable,password,email,contact_number) 
VALUES('Ravichandra','Ashwin','SUPPLIER',true,'supplier','ra@gmail.com','99999999999');


CREATE TABLE product(
 id IDENTITY,
 code VARCHAR(20),
 name VARCHAR(30),
 brand VARCHAR(30),
 description VARCHAR(100),
 unit_price DECIMAL(10,2),
 quantity INT,
 is_active BOOLEAN,
 category_id INT,
 supplier_id INT,
 purchases INT DEFAULT 0,
 views INT DEFAULT 0,
 CONSTRAINT pk_product_id PRIMARY KEY(id), 
 CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
 CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),
);


INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
values('PRDABC123DEFX','iPhone 5s','apple','This is one of the best phone available in the market right now !',18000,1,true,3,2);


INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
values('PRDABC123DEFZ','Samsung s7','samsung','A smart phone by samsung ! ',32000,2,true,3,3);

INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
values('PRDABCXYZDEFX','Google Pioxel','google','This is one of the best android smart phone available in the market right now !',57000,5,true,3,2);

INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
values('PRDABC123DGTX','Macro Pro','apple','This is one of the best laptop available in the market right now !',54000,3,true,1,2);

INSERT INTO product
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
values('PRDABC123PQRX','Dell Latitude E6510','dell','This is one of the best laptop series in the market right now !',48000,5,true,1,3);