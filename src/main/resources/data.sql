INSERT INTO LEAGUES (name, description, active)
VALUES ('NBA', 'National Basketball Association', true);

INSERT INTO LEAGUES (name, description, active)
VALUES ('EuroBasket', 'European international basketball competition', true);

INSERT INTO LEAGUES (name, description, active)
VALUES ('Liga ACB', 'Spanish top professional basketball division', false);

INSERT INTO TEAMS (name, league_id)
VALUES ('Los Angeles Lakers', 1);
INSERT INTO TEAMS (name, league_id)
VALUES ('Boston Celtics', 1);

INSERT INTO TEAMS (name, league_id)
VALUES ('Spain National Team', 2);
INSERT INTO TEAMS (name, league_id)
VALUES ('France National Team', 2);

INSERT INTO TEAMS (name, league_id)
VALUES ('Real Madrid Baloncesto', 3);
INSERT INTO TEAMS (name, league_id)
VALUES ('FC Barcelona Basket', 3);

-- Lakers
INSERT INTO PLAYERS (name, surname, age, email, team_id)
VALUES ('LeBron', 'James', 39, 'lebron.james@lakers.nba', 1);

INSERT INTO PLAYERS (name, surname, age, email, team_id)
VALUES ('Anthony', 'Davis', 31, 'anthony.davis@lakers.nba', 1);

-- Celtics
INSERT INTO PLAYERS (name, surname, age, email, team_id)
VALUES ('Jayson', 'Tatum', 26, 'jayson.tatum@celtics.nba', 2);

-- Spain
INSERT INTO PLAYERS (name, surname, age, email, team_id)
VALUES ('Rudy', 'Fernandez', 39, 'rudy.fernandez@spain.eb', 3);

-- France
INSERT INTO PLAYERS (name, surname, age, email, team_id)
VALUES ('Victor', 'Wembanyama', 20, 'victor.wembanyama@france.eb', 4);

-- Real Madrid
INSERT INTO PLAYERS (name, surname, age, email, team_id)
VALUES ('Sergio', 'Llull', 37, 'sergio.llull@realmadrid.acb', 5);

-- Barcelona
INSERT INTO PLAYERS (name, surname, age, email, team_id)
VALUES ('Álex', 'Abrines', 31, 'alex.abrines@barca.acb', 6);

-- LeBron James → Small Forward (Alero), a veces Power Forward
INSERT INTO PLAYERS_POSITIONS (player_id, position)
VALUES (1, 'SF');
INSERT INTO PLAYERS_POSITIONS (player_id, position)
VALUES (1, 'PF');

-- Anthony Davis → Power Forward / Center
INSERT INTO PLAYERS_POSITIONS (player_id, position)
VALUES (2, 'PF');
INSERT INTO PLAYERS_POSITIONS (player_id, position)
VALUES (2, 'C');

-- Jayson Tatum → Small Forward
INSERT INTO PLAYERS_POSITIONS (player_id, position)
VALUES (3, 'SF');

-- Rudy Fernández → Shooting Guard / Small Forward
INSERT INTO PLAYERS_POSITIONS (player_id, position)
VALUES (4, 'SG');
INSERT INTO PLAYERS_POSITIONS (player_id, position)
VALUES (4, 'SF');

-- Victor Wembanyama → Center / Power Forward
INSERT INTO PLAYERS_POSITIONS (player_id, position)
VALUES (5, 'C');
INSERT INTO PLAYERS_POSITIONS (player_id, position)
VALUES (5, 'PF');

-- Sergio Llull → Point Guard / Shooting Guard
INSERT INTO PLAYERS_POSITIONS (player_id, position)
VALUES (6, 'PG');
INSERT INTO PLAYERS_POSITIONS (player_id, position)
VALUES (6, 'SG');

-- Álex Abrines → Shooting Guard / Small Forward
INSERT INTO PLAYERS_POSITIONS (player_id, position)
VALUES (7, 'SG');
INSERT INTO PLAYERS_POSITIONS (player_id, position)
VALUES (7, 'SF');

