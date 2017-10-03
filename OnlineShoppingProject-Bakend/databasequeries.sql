CREATE TABLE CAT_TAB(
id IDENTITY PRIMARY KEY,
name VARCHAR(44),
description VARCHAR(100),
image_url VARCHAR(33),
is_active BOOLEAN
 
)

create table User_details(
id IDENTITY,
first_name VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
enabled BOOLEAN,
password VARCHAR(50),
contact_number VARCHAR(50),
CONSTRAINT pk_user_id PRIMARY KEY(id),

)

create table product
(
   id IDENTITY,
   code VARCHAR(50),
   name VARCHAR(50),
   brand VARCHAR(50),
   description VARCHAR(50),
   unit_price VARCHAR(50),
   quantity INT,
   is_active BOOLEAN,
   category_id INT,
   supplier_id INT,
   purchases INT DEFAULT 0,
   views INT DEFAULT 0,
   CONSTRAINT pk_product_id PRIMARY KEY(id),
   CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES CAT_TAB(id),
   CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES User_details(id),
   
)


