create database travelingIn2021;

use travelingin2021;

create table CountryInfo(
countryID Integer primary key auto_increment not null,
countryName VARCHAR(50),
vaccineRequirement boolean,
testRequirement boolean,
testValidationTimeByHours integer,
foreignerAllowedToEnter boolean
);

select * from countryInfo;
select countryname from countryinfo;
drop table countryInfo;

create table users(
UserId integer primary key auto_increment not null,
userName varchar(25) not null,
email varchar(50) not null,
nationality integer not null
);

select * from users;
drop table users;

create table usersCountryInfo(
usersID Integer,
countryID Integer,
constraint fk_usersCountryInfo_users foreign key (usersID) references users(userID),
constraint fk_usersCountryInfo_countryInfo foreign key (countryID) references countryinfo(countryID)
);

select * from usersCountryInfo;
drop table usersCountryInfo;

drop table Users;

insert into countryInfo
(CountryName, vaccineRequirement, testRequirement, testVAlidationTimeByHours, foreignerAllowedToEnter)
values
('Albania', FALSE, TRUE, '48', FALSE),
('Andorra', FALSE, TRUE, '48', FALSE),
('Armenia', FALSE, TRUE, '48', FALSE),
('Austria', FALSE, TRUE, '48', FALSE),
('Azerbaijan', FALSE, TRUE, '48', FALSE),
('Belarus', FALSE, TRUE, '48', FALSE),
('Belgium', FALSE, TRUE, '48', FALSE),
('Bosnia And Herzegovina', FALSE, TRUE, '48', FALSE),
('Bulgaria', FALSE, TRUE, '48', FALSE),
('Croatia', FALSE, TRUE, '48', FALSE),
('Cyprus', FALSE, TRUE, '48', FALSE),
('Czechia', FALSE, TRUE, '48', FALSE),
('Denmark', FALSE, TRUE, '48', FALSE),
('Estonia', FALSE, TRUE, '48', FALSE),
('Faroe Islands', FALSE, TRUE, '48', FALSE),
('Finland', FALSE, TRUE, '48', FALSE),
('France', FALSE, TRUE, '48', FALSE),
('Georgia', FALSE, TRUE, '48', FALSE),
('Germany', FALSE, TRUE, '48', FALSE),
('Gibraltar', FALSE, TRUE, '48', FALSE),
('Greece', FALSE, TRUE, '48', FALSE),
('Guernsey', FALSE, TRUE, '48', FALSE),
('Holy See (Vatican City State)', FALSE, TRUE, '48', FALSE),
('Hungary', FALSE, TRUE, '48', FALSE),
('Iceland', FALSE, TRUE, '48', FALSE),
('Ireland', FALSE, TRUE, '48', FALSE),
('Isle Of Man', FALSE, TRUE, '48', FALSE),
('Italy', FALSE, TRUE, '48', FALSE),
('Jersey', FALSE, TRUE, '48', FALSE),
('Kosovo *', FALSE, TRUE, '48', FALSE),
('Kuril Islands', FALSE, TRUE, '48', FALSE),
('Latvia', FALSE, TRUE, '48', FALSE),
('Liechtenstein', FALSE, TRUE, '48', FALSE),
('Lithuania', FALSE, TRUE, '48', FALSE),
('Luxemburg', FALSE, TRUE, '48', FALSE),
('Malta', FALSE, TRUE, '48', FALSE),
('Monaco', FALSE, TRUE, '48', FALSE),
('Montenegro', FALSE, TRUE, '48', FALSE),
('Netherlands', FALSE, TRUE, '48', FALSE),
('Norway', FALSE, TRUE, '48', FALSE),
('Poland', FALSE, TRUE, '48', FALSE),
('Portugal', FALSE, TRUE, '48', FALSE),
('Republic Of Moldova', FALSE, TRUE, '48', FALSE),
('Republic of North Macedonia', FALSE, TRUE, '48', FALSE),
('Romania', FALSE, TRUE, '48', FALSE),
('Russian Federation', FALSE, TRUE, '48', FALSE),
('San Marino', FALSE, TRUE, '48', FALSE),
('Serbia', FALSE, TRUE, '48', FALSE),
('Slovakia', FALSE, TRUE, '48', FALSE),
('Slovenia', FALSE, TRUE, '48', FALSE),
('Spain', FALSE, TRUE, '48', FALSE),
('Svalbar And Jan Mayan', FALSE, TRUE, '48', FALSE),
('Sweden', FALSE, TRUE, '48', FALSE),
('Switzerland', FALSE, TRUE, '48', FALSE),
('Turkey', FALSE, TRUE, '48', FALSE),
('Ukraine', FALSE, TRUE, '48', FALSE),
('United Kingdom', FALSE, TRUE, '48', FALSE)
;



