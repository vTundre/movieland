
--------------------------------------
-- tables
--------------------------------------
create table app_user
(user_id integer generated by default as identity primary key,
 user_first_name varchar(1000) not null unique,
 user_last_name varchar(1000) not null unique,
 user_email varchar(1000) not null unique,
 user_password varchar(1000) not null);


create table country
(country_id integer generated by default as identity primary key,
 country_name varchar(1000) not null unique);


create table genre
(genre_id integer generated by default as identity primary key,
 genre_name varchar(1000) not null unique);


create table movie
 (movie_id integer generated by default as identity primary key,
  movie_name_russian varchar(1000) not null,
  movie_name_native varchar(1000) not null,
  movie_year_of_release varchar(4) not null,
  movie_description varchar(4000) not null,
  movie_rating numeric not null,
  movie_price numeric not null);


create table movie_country
 (movie_country_id integer generated by default as identity primary key,
  movie_id integer not null references movie(movie_id) NOT DEFERRABLE,
  country_id integer not null references country(country_id) NOT DEFERRABLE);


create table movie_genre
 (movie_genre_id integer generated by default as identity primary key,
  movie_id integer not null references movie(movie_id) NOT DEFERRABLE,
  genre_id integer not null references genre(genre_id) NOT DEFERRABLE);


create table review
 (review_id integer generated by default as identity primary key,
  movie_id integer not null references movie(movie_id) NOT DEFERRABLE,
  user_id integer  not null references app_user(user_id) NOT DEFERRABLE,
  review_text varchar(4000));


create table poster
 (poster_id integer generated by default as identity primary key,
  movie_id integer not null references movie(movie_id) NOT DEFERRABLE,
  poster_link varchar(4000) not null);