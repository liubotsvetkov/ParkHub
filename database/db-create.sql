DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS neighborhood;
DROP TABLE IF EXISTS parking_slot;
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

CREATE TABLE parking_slot
(
    id_parking_slot BIGINT NOT NULL AUTO_INCREMENT,
    slot_ident VARCHAR(255) NOT NULL,
    date_time_updated DATETIME(6) NOT NULL,
    state BIT NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    id_neighborhood BIGINT,
    PRIMARY KEY (id_parking_slot),
    FOREIGN KEY (id_neighborhood) REFERENCES neighborhood(id_neighborhood),
    CONSTRAINT id_parking_slot1 UNIQUE (id_neighborhood, slot_ident),
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

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('1', NOW(), 0, 42.674075, 23.327411, 1);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('2', NOW(), 0, 42.673790, 23.326155, 1);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('3', NOW(), 0, 42.673269, 23.324577, 1);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('4', NOW(), 0, 42.671219, 23.317497, 1);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('5', NOW(), 0, 42.671042, 23.316859, 1);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('6', NOW(), 0, 42.671775, 23.316603, 1);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('7', NOW(), 0, 42.672113, 23.317141, 1);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('8', NOW(), 0, 42.672088, 23.315966, 1);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('9', NOW(), 0, 42.673264, 23.317914, 1);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('10', NOW(), 0, 42.674256, 23.321548, 1);

INSERT INTO neighborhood (name, id_city) VALUES
    ('Mladost 1', 1);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('1', NOW(), 0, 42.649525, 23.381943, 2);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('2', NOW(), 0, 42.651112, 23.382818, 2);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('3', NOW(), 0, 42.650574, 23.384692, 2);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('4', NOW(), 0, 42.647682, 23.384633, 2);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('5', NOW(), 0, 42.648766, 23.384017, 2);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('6', NOW(), 0, 42.652810, 23.368604, 2);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('7', NOW(), 0, 42.654012, 23.368627, 2);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('8', NOW(), 0, 42.654545, 23.372599, 2);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('9', NOW(), 0, 42.655705, 23.375675, 2);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('10', NOW(), 0, 42.655857, 23.375856, 2);

INSERT INTO city (name) VALUES
    ('Blagoevgrad');

INSERT INTO neighborhood (name, id_city) VALUES
    ('Center', 2);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('1', NOW(), 0, 42.021982, 23.094354, 3);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('2', NOW(), 0, 42.022388, 23.095178, 3);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('3', NOW(), 0, 42.022285, 23.099513, 3);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('4', NOW(), 0, 42.022788, 23.101076, 3);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('5', NOW(), 0, 42.021704, 23.101896, 3);

INSERT INTO neighborhood (name, id_city) VALUES
    ('Strumsko', 2);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('1', NOW(), 0, 41.992930, 23.088639, 4);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('2', NOW(), 0, 41.993497, 23.088120, 4);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('3', NOW(), 0, 41.992343, 23.088509, 4);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('4', NOW(), 0, 41.988891, 23.082011, 4);

INSERT INTO parking_slot(slot_ident, date_time_updated, state, latitude, longitude, id_neighborhood) VALUES
    ('5', NOW(), 0, 41.991576, 23.085338, 4);

