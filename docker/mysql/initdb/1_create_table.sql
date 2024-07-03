CREATE TABLE if not exists spots(
    spot_id int auto_increment primary key,
    spot_name varchar(100) not null,
    contents varchar(255) not null,
    registered_at varchar(25) not null,
    updated_time varchar(25),
    FOREIGN KEY(user_id)REFERENCES user_info(user_id)
) engine = InnoDB;