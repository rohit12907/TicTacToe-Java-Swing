CREATE DATABASE tictac_db;
USE tictac_db;

CREATE TABLE game_result (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player1 VARCHAR(50),
    player2 VARCHAR(50),
    winner VARCHAR(50),
    match_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
