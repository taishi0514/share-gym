CREATE TABLE if not exists user_info(
    user_id int auto_increment primary key, 
    user_name varchar(50) not null, 
    email varchar(50) not null, 
    password varchar(100) not null, 
    created_at varchar(25) not null, 
    updated_at varchar(25),
    UNIQUE KEY (email)
) engine = InnoDB;

CREATE TABLE if not exists spots(
    spot_id int auto_increment primary key,
    spot_name varchar(100) not null,
    contents varchar(255) not null,
    registered_at varchar(25) not null,
    updated_time varchar(25),
    FOREIGN KEY(user_id)REFERENCES user_info(user_id)
) engine = InnoDB;

CREATE TABLE if not exists favorites(
    id int AUTO_INCREMENT PRIMARY KEY,
    user_id int NOT NULL,
    spot_id int NOT NULL,
    createdAt varchar(25) NOT NULL,
    FOREIGN KEY(user_id)REFERENCES user_info(user_id)
) engine = InnoDB;	   		
			
			
CREATE TABLE if not exists categories (
    id int NOT NULL AUTO_INCREMENT,
    body varchar(255) NOT NULL,
    PRIMARY KEY (ID)
) engine = InnoDB;
			
			
			
			
			
			
			
			
					
			
			
			
			
			
			