CREATE USER 'xabook'@'localhost' IDENTIFIED BY 'xabook';
create database xabook;
grant all on xabook.* to 'xabook'@'localhost';