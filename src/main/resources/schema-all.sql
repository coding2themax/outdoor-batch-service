DROP TABLE park IF EXISTS;

CREATE TABLE park (parkCode varchar(80) PRIMARY KEY,  url VARCHAR(255), fullName VARCHAR(255), description VARCHAR(255) );

CREATE TABLE usstate(id varchar(2) PRIMARY KEY, fullName varchar(80));

CREATE TABLE statepark( id varchar(2) references usstate(id), parkCode VARCHAR(80) references park(parkCode));

