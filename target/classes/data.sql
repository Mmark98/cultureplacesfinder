INSERT INTO users (id,age,email,name,password,role) VALUES (null,'20','1@email.com','Felhasznaló_1','{bcrypt}$2a$10$MPEbOmc1tpEWFF9YPNLdqOmdTDZoiUw91uZxnOY6ylTcT6Ycsrm6K','USER');
INSERT INTO users (id,age,email,name,password,role) VALUES (null,'20','2@email.com','Felhasznaló_2','{bcrypt}$2a$10$nDqe1sTDYxzVl464YOS75eqMaVld02NhUtWomrNceEi1ghE2ZAElm','USER');
INSERT INTO posts (id,content,posted,sub_title,title,user_id) VALUES ('1','	Ez itt a poszt tartalma.','2021-04-23','Alcím 1','Főcím 1','1');
INSERT INTO posts (id,content,posted,sub_title,title,user_id) VALUES ('2','	Ez itt a 2. poszt tartalma','2021-04-23','Alcím 2','Főcím 2','2');