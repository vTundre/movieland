create table temp_poster
 (movie_name_russian varchar(1000),
  poster_link varchar(4000));

insert into temp_poster values(
'Побег из Шоушенка', 'https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg');

insert into temp_poster values(
'Зеленая миля', 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg');

insert into temp_poster values(
'Форрест Гамп', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR2,0,140,209_.jpg');

insert into temp_poster values(
'Список Шиндлера', 'https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg');

update movie um
   set poster_url = (select t.poster_link
                       from temp_poster t, movie m
                      where t.movie_name_russian = m.movie_name_russian and m.movie_id = um.movie_id);

drop table temp_poster;