create database if not exists federatedsearch;
use federatedsearch;


create table if not exists merge_results (
	result_id INT PRIMARY KEY,	
	imdb_id VARCHAR(100),
	search_term VARCHAR(100),
	title VARCHAR(100),
	poster VARCHAR(100),
	genre VARCHAR(100),
	awards VARCHAR(100),
	imdb_rating VARCHAR(100),
	actors VARCHAR(100),
	years INT,
	country VARCHAR(100),
	url VARCHAR(100),
	overview LONGTEXT,
	time_added TIMESTAMP
);
