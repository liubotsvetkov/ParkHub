DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS neighborhood;
DROP TABLE IF EXISTS parking_slot;
DROP TABLE IF EXISTS parking_zone;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_authorities;

CREATE TABLE city
(
    id_city BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (id_city)
);

CREATE TABLE neighborhood
(
    id_neighborhood BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    id_city BIGINT,
    PRIMARY KEY (id_neighborhood),
    FOREIGN KEY (id_city) REFERENCES city(id_city),
    CONSTRAINT id_neighborhood UNIQUE (id_city, name)
);

CREATE TABLE parking_zone
(
    id_parking_zone BIGINT NOT NULL AUTO_INCREMENT,
    zone_ident VARCHAR(255) NOT NULL,
    id_neighborhood BIGINT,
    PRIMARY KEY (id_parking_zone),
    FOREIGN KEY (id_neighborhood) REFERENCES neighborhood(id_neighborhood),
    CONSTRAINT id_parking_zone UNIQUE (id_neighborhood, zone_ident)
);

CREATE TABLE parking_slot
(
    id_parking_slot BIGINT NOT NULL AUTO_INCREMENT,
    slot_ident VARCHAR(255) NOT NULL,
    date_time_updated DATETIME(6) NOT NULL,
    state BIT NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    id_parking_zone BIGINT,
    PRIMARY KEY (id_parking_slot),
    FOREIGN KEY (id_parking_zone) REFERENCES parking_zone(id_parking_zone),
    CONSTRAINT id_parking_slot1 UNIQUE (id_parking_zone, slot_ident),
    CONSTRAINT id_parking_slot2 UNIQUE (latitude, longitude)
);

CREATE TABLE users
(
    id_user BIGINT NOT NULL AUTO_INCREMENT,
    enabled BIT NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_user)
);

CREATE TABLE user_authorities
(
    id_user_authorities BIGINT NOT NULL AUTO_INCREMENT,
    authority VARCHAR(255) NOT NULL,
    id_user BIGINT,
    PRIMARY KEY (id_user_authorities),
    FOREIGN KEY (id_user) REFERENCES users(id_user)
);

CREATE TABLE payment
(
    id_payment BIGINT NOT NULL AUTO_INCREMENT,
    payment_date DATETIME(6) NOT NULL,
    id_user BIGINT,
    PRIMARY KEY (id_payment),
    FOREIGN KEY (id_user) REFERENCES users(id_user)
);

INSERT INTO city (name) VALUES
    ('Sofia');

INSERT INTO neighborhood (name, id_city) VALUES
    ('Lozenets', 1);

INSERT INTO parking_zone(zone_ident, id_neighborhood) VALUES
    ('A1', 1);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_parking_zone) VALUES
    ('9', NOW(), 0, 11.1111, 12.1212, 1);

INSERT INTO neighborhood (name, id_city) VALUES
    ('Center', 1);

INSERT INTO parking_zone(zone_ident, id_neighborhood) VALUES
    ('B3', 2);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_parking_zone) VALUES
    ('8', NOW(), 0, 66.1111, 67.1212, 2);

INSERT INTO parking_zone(zone_ident, id_neighborhood) VALUES
    ('B4', 2);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_parking_zone) VALUES
    ('9', NOW(), 0, 68.1111, 69.1212, 3);

INSERT INTO city (name) VALUES
    ('Bremen');

INSERT INTO neighborhood (name, id_city) VALUES
    ('Vegesack', 2);

INSERT INTO parking_zone(zone_ident, id_neighborhood) VALUES
    ('B3', 3);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_parking_zone) VALUES
    ('11', NOW(), 0, 13.1111, 14.1212, 4);

