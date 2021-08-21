CREATE TABLE roles (
    id BIGINT not null auto_increment primary key,
    name VARCHAR(30) NOT NULL,
    description VARCHAR(100)
);

ALTER TABLE myusers ADD COLUMN id_role BIGINT;
ALTER TABLE myusers ADD FOREIGN KEY (id_role) REFERENCES roles (id);