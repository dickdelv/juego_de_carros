CREATE TABLE IF NOT EXISTS game (
id_game INTEGER(10) NOT NULL,
PRIMARY KEY (id_game)
);

CREATE TABLE IF NOT EXISTS track (
id_track INTEGER(10) NOT NULL,
name_track VARCHAR (30) NOT NULL,
distance_track INTEGER(10) NOT NULL,
PRIMARY KEY (id_track)
);

CREATE TABLE IF NOT EXISTS lane (
id_lane INTEGER(10) NOT NULL,
id_track INTEGER(10),
PRIMARY KEY (id_lane),
FOREIGN KEY (id_track) REFERENCES track (id_track)
);

CREATE TABLE IF NOT EXISTS car (
id_car INTEGER(10) NOT NULL,
colour_car VARCHAR (30) NOT NULL,
brand_car VARCHAR (20) NOT NULL,
id_lane INTEGER(10),
PRIMARY KEY (id_car),
FOREIGN KEY (id_lane) REFERENCES lane (id_lane)
);

CREATE TABLE IF NOT EXISTS driver (
id_player INTEGER(10) NOT NULL,
name_player VARCHAR(50) NOT NULL,
id_car INTEGER(10),
PRIMARY KEY (id_player),
FOREIGN KEY (id_car) REFERENCES car (id_car)
);

CREATE TABLE IF NOT EXISTS podium (
id_podium INTEGER(10) NOT NULL,
id_game INTEGER(10),
id_first_place INTEGER(10),
id_second_place INTEGER(10),
id_third_place INTEGER(10),
PRIMARY KEY (id_podium),
FOREIGN KEY (id_game) REFERENCES game (id_game),
FOREIGN KEY (id_first_place) REFERENCES driver (id_player),
FOREIGN KEY (id_second_place) REFERENCES driver (id_player),
FOREIGN KEY (id_third_place) REFERENCES driver (id_player)
);