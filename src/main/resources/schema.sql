CREATE TABLE food(
	foodId INT NOT NULL AUTO_INCREMENT,
	userName VARCHAR(255) NOT NULL,
	foodName VARCHAR(255) NOT NULL,
	category VARCHAR(255) NOT NULL,
	num INT NOT NULL,
	expirationDate DATE NOT NULL,
	PRIMARY KEY (foodId)
);

CREATE TABLE user(
	userName VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	roleName VARCHAR(255) NOT NULL,
	PRIMARY KEY (userName)
);


CREATE TABLE recipe(
	recipeId INT NOT NULL AUTO_INCREMENT,
	recipeName VARCHAR(255) NOT NULL,
	neededFood VARCHAR(255),
	PRIMARY KEY (recipeId)
);