
# Wildlife Tracker
## Author
By Sitati Solomon

## Description
It is an application that allows Rangers to track wildlife sightings in various places.
## Setup/Installation Requirements
* git clone https://github.com/mabunde/Wildlife-service.git
* cd to Wildlife-service/
* open with intellij IDEA or your preferred editor
* Run the gradle
* Open the localhost on your browser

## DATABASE SETUP
* CREATE DATABASE wildlife_tracker;
* CREATE TABLE animals (id serial PRIMARY KEY, name VARCHAR, danger VARCHAR, health VARCHAR, age VARCHAR, location VARCHAR,ranger VARCHAR);
* CREATE TABLE sightings (id serial PRIMARY KEY, animalId int, location VARCHAR, rangername VARCHAR, lastsighting timestamp);
####TEST DATABASE SETUP
* CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
## Behaviour Driven Development
#### 1. Prompt the user to fill the animal track form
INPUT: "Animal name"
INPUT: "Endangered or Not endangered"
INPUT: "Health status"
INPUT: "Age"
INPUT: "Location sighted"
INPUT: "Ranger name"

#### 2.Displays the tracked animal
OUTPUT: "Animal name"
OUTPUT: "Endangered or Not endangered"
OUTPUT: "Health status"
OUTPUT: "Age"
OUTPUT: "Location sighted"
OUTPUT: "Ranger name"

#### 3.Displays the list of animals tracked
OUTPUT: "Animal one"
OUTPUT: "Animal two"
OUTPUT: "Animal three"
## Technologies Used
* Java
* Spark
* Handlebars
* PostgreSQL 
* Bootstrap
* CSS
## Java known bugs

## Support and contact details
For support contact solomonsitati39@gmail.com

## License
MIT License

## Copyright (c) 2021 Sitati Solomon