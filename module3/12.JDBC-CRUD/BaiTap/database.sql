DROP DATABASE IF EXISTS demo;
CREATE DATABASE demo;
USE demo;

CREATE TABLE users (
	 id  INT(3) NOT NULL AUTO_INCREMENT,
	 name VARCHAR(120) NOT NULL,
	 email VARCHAR(220) NOT NULL,
	 country VARCHAR(120) NOT NULL,
	 PRIMARY KEY (id)
);

create table Permision(
	id int(11) primary key auto_increment,
	`name` varchar(50) 
);

 create table User_Permision(
	permision_id int(11)  ,
	user_id int(11) ,
	FOREIGN	KEY	(permision_id) REFERENCES Permision(id),
	FOREIGN	KEY	(user_id) REFERENCES users(id)
);

INSERT INTO users(name, email, country) VALUES('Minh','minh@codegym.vn','Viet Nam');
INSERT INTO users(name, email, country) VALUES('Kante','kante@che.uk','Kenia');

insert into Permision(name) values('add');

insert into Permision(name) values('edit');

insert into Permision(name) values('delete');

insert into Permision(name) values('view');

DELIMITER $$

CREATE PROCEDURE get_user_by_id(IN user_id INT)

BEGIN

    SELECT users.name, users.email, users.country

    FROM users

    where users.id = user_id;

    END$$

DELIMITER ;

  

DELIMITER $$

CREATE PROCEDURE insert_user(

IN user_name varchar(50),

IN user_email varchar(50),

IN user_country varchar(50)

)

BEGIN

    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);

    END$$

DELIMITER ;