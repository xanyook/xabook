CREATE USER 'xabook'@'localhost' IDENTIFIED BY 'xabook';
create database xabook;
grant all on xabook.* to 'xabook'@'localhost';


INSERT INTO type (book_type) VALUES ('BD');