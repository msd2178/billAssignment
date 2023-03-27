DROP table IF EXISTS movie_actor;
DROP table IF EXISTS actor;
DROP table IF EXISTS movie;

CREATE TABLE actor (
   id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   actor VARCHAR NOT NULL UNIQUE
);

CREATE TABLE movie (
   id int NOT NULL AUTO_INCREMENT  PRIMARY KEY,
   title VARCHAR NOT NULL,
   releasedate VARCHAR NOT NULL,
   CONSTRAINT uc_movie_releasedate unique (title, releasedate)
);

CREATE TABLE movie_actor (
   id int NOT NULL AUTO_INCREMENT  PRIMARY KEY,
   id_movie int,
   FOREIGN KEY (id_movie) REFERENCES movie(id),
   id_actor int,
   FOREIGN KEY (id_actor) REFERENCES actor(id),
   CONSTRAINT uc_movie_actor unique (id_movie, id_actor)
);