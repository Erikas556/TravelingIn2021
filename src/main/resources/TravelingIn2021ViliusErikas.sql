create database travelingIn2021;

use travelingin2021;

create table countryInfo(
ID Integer primary key auto_increment not null,
countryName VARCHAR(50),
vaccineRequirement boolean,
testRequirement boolean,
testValidationTimeByHours integer,
foreignerAllowedToEnter boolean,
UNIQUE KEY (countryName)
);

create table users(
Id integer primary key auto_increment not null,
userName varchar(25) not null,
email varchar(50) not null
);

select * from countryInfo;

insert into users
(userName, email)
values
('Giedrius', 'testing@inbox.com');

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
('Cyprus', FALSE, TRUE, '150', True),
('Czechia', FALSE, TRUE, '48', FALSE),
('Denmark', FALSE, TRUE, '48', FALSE),
('Estonia', FALSE, False, '15', FALSE),
('Faroe Islands', FALSE, TRUE, '48', FALSE),
('Finland', FALSE, TRUE, '48', FALSE),
('France', FALSE, TRUE, '48', FALSE),
('Georgia', FALSE, TRUE, '48', FALSE),
('Germany', FALSE, TRUE, '48', FALSE),
('Gibraltar', FALSE, TRUE, '48', FALSE),
('Greece', FALSE, TRUE, '48', FALSE),
('Guernsey', FALSE, TRUE, '48', FALSE),
('Hungary', FALSE, TRUE, '48', FALSE),
('Iceland', FALSE, TRUE, '48', FALSE),
('Ireland', FALSE, TRUE, '48', FALSE),
('Italy', FALSE, TRUE, '48', FALSE),
('Jersey', FALSE, TRUE, '48', FALSE),
('Kosovo', FALSE, TRUE, '48', FALSE),
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
('Moldova', FALSE, TRUE, '48', FALSE),
('Macedonia', FALSE, TRUE, '48', FALSE),
('Romania', FALSE, TRUE, '48', FALSE),
('Russia', FALSE, TRUE, '48', FALSE),
('San Marino', FALSE, TRUE, '48', FALSE),
('Serbia', FALSE, TRUE, '48', FALSE),
('Slovakia', FALSE, TRUE, '48', FALSE),
('Slovenia', FALSE, TRUE, '48', FALSE),
('Spain', FALSE, TRUE, '48', FALSE),
('Sweden', FALSE, TRUE, '48', FALSE),
('Switzerland', FALSE, TRUE, '48', FALSE),
('Turkey', FALSE, TRUE, '48', FALSE),
('Ukraine', FALSE, TRUE, '48', FALSE),
('United Kingdom', FALSE, TRUE, '48', FALSE)
;
drop database travelingin2021;

