CREATE DATABASE wildlife_tracker;
CREATE TABLE animals (id serial PRIMARY KEY, name VARCHAR, endangered VARCHAR, health VARCHAR, age INT, location VARCHAR);

CREATE TABLE sightings (id serial PRIMARY KEY, animalId int, location VARCHAR, rangername VARCHAR, lastsighting timestamp);
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;