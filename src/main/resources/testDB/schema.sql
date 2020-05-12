CREATE TABLE airport (
  id           INT(11)     NOT NULL AUTO_INCREMENT,
  city         VARCHAR(60) NOT NULL,
  airport_code VARCHAR(10) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE airport_code_UNIQUE (airport_code)
);


CREATE TABLE professions (
  id              INT(11)     NOT NULL AUTO_INCREMENT,
  profession_name VARCHAR(20) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE profession_name_UNIQUE (profession_name)
);


CREATE TABLE user_type (
  id             INT(11)     NOT NULL AUTO_INCREMENT,
  user_type_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE user_type_name_UNIQUE (user_type_name)
);

CREATE TABLE flight_status
(
  id                 INT(11)     NOT NULL AUTO_INCREMENT,
  flight_status_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE flight_status_name_UNIQUE (flight_status_name)
);

CREATE TABLE crew_man (
  id            INT(11)     NOT NULL AUTO_INCREMENT,
  first_name    VARCHAR(50) NOT NULL,
  last_name     VARCHAR(50) NOT NULL,
  date_of_birth DATE        NOT NULL,
  profession_id INT(11)     NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT Crew_man_to_Profession FOREIGN KEY (profession_id)
  REFERENCES professions (id)
);

CREATE TABLE flights (
  id                   INT(11)     NOT NULL AUTO_INCREMENT,
  flight_code          VARCHAR(10) NOT NULL,
  departure_airport_id INT(11)     NOT NULL,
  arrival_airport_id   INT(11)     NOT NULL,
  departure_time       TIMESTAMP   NOT NULL,
  arrival_time         TIMESTAMP   NOT NULL,
  flight_status_id     INT(11)     NOT NULL,
  PRIMARY KEY (id),

  CONSTRAINT Flight_to_Arrival_Airport FOREIGN KEY (arrival_airport_id)
  REFERENCES airport (id),

  CONSTRAINT Flight_to_Departure_Airport FOREIGN KEY (departure_airport_id)
  REFERENCES airport (id),

  CONSTRAINT Flight_to_Flight_Status FOREIGN KEY (flight_status_id)
  REFERENCES flight_status (id)
);

CREATE TABLE user (
  id           INT(11)      NOT NULL AUTO_INCREMENT,
  first_name   VARCHAR(50)  NOT NULL,
  last_name    VARCHAR(50)  NOT NULL,
  login        VARCHAR(20)  NOT NULL,
  password     VARCHAR(100) NOT NULL,
  user_type_id INT(11)      NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX login_UNIQUE (login),
  CONSTRAINT user_vs_user_type FOREIGN KEY (user_type_id)
  REFERENCES user_type (id)
);
