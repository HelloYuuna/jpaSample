DROP TABLE Member;

CREATE TABLE Member (
    email varchar2(320) primary key ,
    password varchar2(50) not null
);