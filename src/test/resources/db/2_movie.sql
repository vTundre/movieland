create table temp_movie
 (movie_name_russian varchar(1000),
  movie_name_native varchar(1000),
  movie_year_of_release varchar(4),
  country varchar(1000),
  genre varchar(1000),
  movie_description varchar(4000),
  movie_rating numeric,
  movie_price numeric);


insert into temp_movie values(
'Побег из Шоушенка', 'The Shawshank Redemption',
'1994',
'США',
'драма, криминал',
'Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.',
'8.9',
'123.45');

insert into temp_movie values(
'Зеленая миля', 'The Green Mile',
'1999',
'США',
'фэнтези, драма',
'Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор.',
'9.0',
'134.67');

insert into temp_movie values(
'Форрест Гамп', 'Forrest Gump',
'1994',
'США',
'драма, мелодрама',
'От лица главного героя Форреста Гампа, слабоумного безобидного человека с благородным и открытым сердцем, рассказывается история его необыкновенной жизни.Фантастическим образом превращается он в известного футболиста, героя войны, преуспевающего бизнесмена. Он становится миллиардером, но остается таким же бесхитростным, глупым и добрым. Форреста ждет постоянный успех во всем, а он любит девочку, с которой дружил в детстве, но взаимность приходит слишком поздно.',
'8.6',
'200.60');

insert into temp_movie values(
'Список Шиндлера', 'Schindler''s List',
'1993',
'США',
'драма, биография',
'Фильм рассказывает реальную историю загадочного Оскара Шиндлера, члена нацистской партии, преуспевающего фабриканта, спасшего во время Второй мировой войны почти 1200 евреев.',
'8.7',
'150.50');

--------------------------------------
insert into movie(movie_name_russian, movie_name_native, movie_year_of_release, movie_description , movie_rating, movie_price)
select movie_name_russian , movie_name_native, movie_year_of_release, movie_description , movie_rating, movie_price
  from temp_movie;

insert into movie_country(movie_id, country_id)
select m.movie_id, c.country_id
  from temp_movie t, country c, movie m
 where position(lower(c.country_name || ',') in lower(t.country) || ',') > 0
   and t.movie_name_russian = m.movie_name_russian;

insert into movie_genre(movie_id, genre_id)
select  m.movie_id, g.genre_id
  from temp_movie t, genre g, movie m
 where position(lower(g.genre_name || ',') in lower(t.genre) || ',') >0 and t.movie_name_russian = m.movie_name_russian;


drop table  temp_movie;