SET MODE PostgreSQL;
CREATE DATABASE wildlife_tracker;
CREATE TABLE IF NOT EXISTS animals
(id serial PRIMARY KEY, name VARCHAR, danger VARCHAR, health VARCHAR, age VARCHAR, location VARCHAR,ranger VARCHAR);

CREATE TABLE IF NOT EXISTS
sightings  (id serial PRIMARY KEY, animalId int, location VARCHAR, rangername VARCHAR, lastsighting timestamp);

CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;