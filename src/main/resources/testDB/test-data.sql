INSERT INTO airport (id, city, airport_code) VALUES (1, 'Moscow', 'VKO');
INSERT INTO airport (id, city, airport_code) VALUES (2, 'Minsk', 'MSQ');
INSERT INTO airport (id, city, airport_code) VALUES (3, 'Kiev', 'IEV');
INSERT INTO airport (id, city, airport_code) VALUES (4, 'Krasnodar', 'KRR');

INSERT INTO user_type (id, user_type_name) VALUES (1, 'MODERATOR');
INSERT INTO user_type (id, user_type_name) VALUES (2, 'ADMINISTRATOR');
INSERT INTO user_type (id, user_type_name) VALUES (3, 'DISPATCHER');

INSERT INTO professions (id, profession_name) VALUES (1, 'PILOT');
INSERT INTO professions (id, profession_name) VALUES (2, 'NAVIGATOR');
INSERT INTO professions (id, profession_name) VALUES (3, 'RADIOMAN');
INSERT INTO professions (id, profession_name) VALUES (4, 'STEWARD');

INSERT INTO flight_status (id, flight_status_name) VALUES (1, 'OPENED');
INSERT INTO flight_status (id, flight_status_name) VALUES (2, 'DONE');
INSERT INTO flight_status (id, flight_status_name) VALUES (3, 'CANCELED');
INSERT INTO flight_status (id, flight_status_name) VALUES (4, 'BOARDING');
INSERT INTO flight_status (id, flight_status_name) VALUES (5, 'CHECKIN');
INSERT INTO flight_status (id, flight_status_name) VALUES (6, 'DEPARTED');
INSERT INTO flight_status (id, flight_status_name) VALUES (7, 'LANDED');
INSERT INTO flight_status (id, flight_status_name) VALUES (8, 'UNREGISTERED');

INSERT INTO user (id, first_name, last_name, login, password, user_type_id) VALUES (1, 'Максим', 'Ржевуцкий', 'maximus', 'max090485', 1);
INSERT INTO user (id, first_name, last_name, login, password, user_type_id) VALUES (2, 'Денис', 'Новиков', 'denisus', 'den0312', 2);
INSERT INTO user (id, first_name, last_name, login, password, user_type_id) VALUES (3, 'Влад', 'Поповичус', 'vladikus', 'ol1221', 2);
INSERT INTO user (id, first_name, last_name, login, password, user_type_id) VALUES (4, 'Василий', 'Теркин', 'vaslus', 'vas1212', 3);

INSERT INTO crew_man (id, first_name, last_name, date_of_birth, profession_id) VALUES (1, 'Darius', 'Rosiello', '1977-04-21', 1);
INSERT INTO crew_man (id, first_name, last_name, date_of_birth, profession_id) VALUES (2, 'Tabina', 'Trenouth', '1985-12-06', 4);
INSERT INTO crew_man (id, first_name, last_name, date_of_birth, profession_id) VALUES (3, 'Bette-ann', 'Flecknoe', '1989-12-25', 4);
INSERT INTO crew_man (id, first_name, last_name, date_of_birth, profession_id) VALUES (4, 'Jenine', 'Redman', '1978-05-31', 1);
INSERT INTO crew_man (id, first_name, last_name, date_of_birth, profession_id) VALUES (5, 'Борис', 'Годунов', '1982-07-01', 4);
INSERT INTO crew_man (id, first_name, last_name, date_of_birth, profession_id) VALUES (6, 'Mario', 'Stroban', '1985-08-11', 1);
INSERT INTO crew_man (id, first_name, last_name, date_of_birth, profession_id) VALUES (7, 'Mommy', 'Albert', '1986-07-13', 3);
INSERT INTO crew_man (id, first_name, last_name, date_of_birth, profession_id) VALUES (8, 'Chrissy', 'Skoggings', '1990-03-15', 2);

INSERT INTO flights (id, flight_code, departure_airport_id, arrival_airport_id, departure_time, arrival_time, flight_status_id) VALUES (1, 'LESI4199', 1, 2, '2020-03-29 20:30:00', '2020-03-29 21:50:00', 8);
INSERT INTO flights (id, flight_code, departure_airport_id, arrival_airport_id, departure_time, arrival_time, flight_status_id) VALUES (2, 'MSRO3551', 1, 3, '2020-03-04 18:50:00', '2020-03-04 20:50:00', 2);
INSERT INTO flights (id, flight_code, departure_airport_id, arrival_airport_id, departure_time, arrival_time, flight_status_id) VALUES (3, 'KRLE1780', 2, 4, '2020-03-02 11:50:00', '2020-03-02 13:50:00', 1);
INSERT INTO flights (id, flight_code, departure_airport_id, arrival_airport_id, departure_time, arrival_time, flight_status_id) VALUES (4, 'VKVL9444', 3, 2, '2020-03-07 08:50:00', '2020-03-07 10:50:00', 3);

INSERT INTO flight_crewman (flight_id, crewman_id) VALUES (1, 1);
INSERT INTO flight_crewman (flight_id, crewman_id) VALUES (1, 2);
INSERT INTO flight_crewman (flight_id, crewman_id) VALUES (1, 3);
INSERT INTO flight_crewman (flight_id, crewman_id) VALUES (2, 1);
INSERT INTO flight_crewman (flight_id, crewman_id) VALUES (2, 5);
INSERT INTO flight_crewman (flight_id, crewman_id) VALUES (3, 6);
INSERT INTO flight_crewman (flight_id, crewman_id) VALUES (3, 3);
INSERT INTO flight_crewman (flight_id, crewman_id) VALUES (4, 1);
INSERT INTO flight_crewman (flight_id, crewman_id) VALUES (4, 2);