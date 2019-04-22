CREATE TABLE `User` (
	`userID` int NOT NULL AUTO_INCREMENT,
	`name` varchar(30) NOT NULL,
	`BirthDate` DATE NOT NULL,
	`password` varchar(30) NOT NULL,
	`job` varchar(50) NOT NULL,
	`email` varchar(50) NOT NULL,
	`creditLimit` double NOT NULL,
	`address` varchar(100) NOT NULL,
	`phone` varchar(20) NOT NULL,
	`gender` varchar(20) NOT NULL,
	PRIMARY KEY (`userID`)
);

CREATE TABLE `Wish_List` (
	`bookID` int NOT NULL,
	`userID` int NOT NULL,
	PRIMARY KEY (`bookID`,`userID`)
);

CREATE TABLE `Book` (
	`bookID` int NOT NULL AUTO_INCREMENT,
	`title` varchar(200) NOT NULL,
	`descripe` varchar(1500) NOT NULL,
	`authorName` varchar(100) NOT NULL,
	`price` double NOT NULL,
	`img` varchar(250) NOT NULL,
	`visits` int NOT NULL,
	`rate` double NOT NULL,
	`quantity` int NOT NULL,
	`pagesNumber` int NOT NULL,
	`soldAmount` int NOT NULL,
	`available` TINYINT NOT NULL,
	`keyWords` varchar(500) NOT NULL,
	`categoryID` int NOT NULL,
	`offerID` int NOT NULL,
        `reviews` int NULL,
	PRIMARY KEY (`bookID`)
);

CREATE TABLE `Category` (
	`categoryID` int NOT NULL AUTO_INCREMENT,
	`categoryName` varchar(50) NOT NULL,
	PRIMARY KEY (`categoryID`)
);

CREATE TABLE `Offer` (
	`offerID` int NOT NULL AUTO_INCREMENT,
	`offerPercentage` int NOT NULL,
	`expireDate` DATE NOT NULL,
	PRIMARY KEY (`offerID`)
);

CREATE TABLE `User_Visit_Book` (
	`userID` int NOT NULL,
	`bookID` int NOT NULL,
	`visitsNumber` int NOT NULL,
	PRIMARY KEY (`userID`,`bookID`)
);

CREATE TABLE `User_Cart_Book` (
	`userID` int NOT NULL,
	`bookID` int NOT NULL,
	`reqQuantity` int NOT NULL,
	`availableQuantity` int NOT NULL,
	PRIMARY KEY (`userID`,`bookID`)
);

CREATE TABLE `Book_Order` (
	`orderID` int NOT NULL,
	`bookID` int NOT NULL,
	`deliveryDate` DATE NOT NULL,
	`quantity` int NOT NULL,
	`price` double NOT NULL,
	PRIMARY KEY (`orderID`,`bookID`)
);

CREATE TABLE `User_Order` (
	`orderID` int NOT NULL AUTO_INCREMENT,
	`userID` int NOT NULL,
	PRIMARY KEY (`orderID`)
);

CREATE TABLE `User_Category` (
	`userID` int NOT NULL,
	`categoryID` int NOT NULL,
	PRIMARY KEY (`userID`,`categoryID`)
);

CREATE TABLE `Admin` (
	`adminID` int NOT NULL AUTO_INCREMENT,
	`name` varchar(50) NOT NULL,
	`password` varchar(30) NOT NULL,
	PRIMARY KEY (`adminID`)
);

ALTER TABLE `Wish_List` ADD CONSTRAINT `Wish_List_fk0` FOREIGN KEY (`bookID`) REFERENCES `Book`(`bookID`);

ALTER TABLE `Wish_List` ADD CONSTRAINT `Wish_List_fk1` FOREIGN KEY (`userID`) REFERENCES `User`(`userID`);

ALTER TABLE `Book` ADD CONSTRAINT `Book_fk0` FOREIGN KEY (`categoryID`) REFERENCES `Category`(`categoryID`);

ALTER TABLE `Book` ADD CONSTRAINT `Book_fk1` FOREIGN KEY (`offerID`) REFERENCES `Offer`(`offerID`);

ALTER TABLE `User_Visit_Book` ADD CONSTRAINT `User_Visit_Book_fk0` FOREIGN KEY (`userID`) REFERENCES `User`(`userID`);

ALTER TABLE `User_Visit_Book` ADD CONSTRAINT `User_Visit_Book_fk1` FOREIGN KEY (`bookID`) REFERENCES `Book`(`bookID`);

ALTER TABLE `User_Cart_Book` ADD CONSTRAINT `User_Cart_Book_fk0` FOREIGN KEY (`userID`) REFERENCES `User`(`userID`);

ALTER TABLE `User_Cart_Book` ADD CONSTRAINT `User_Cart_Book_fk1` FOREIGN KEY (`bookID`) REFERENCES `Book`(`bookID`);

ALTER TABLE `Book_Order` ADD CONSTRAINT `Book_Order_fk0` FOREIGN KEY (`bookID`) REFERENCES `Book`(`bookID`);

ALTER TABLE `Book-Order` ADD CONSTRAINT `Book-Order_fk1` FOREIGN KEY (`orderID`) REFERENCES `User-Order`(`orderID`);

ALTER TABLE `User-Order` ADD CONSTRAINT `User-Order_fk0` FOREIGN KEY (`userID`) REFERENCES `User`(`userID`);

ALTER TABLE `User-Category` ADD CONSTRAINT `User-Category_fk0` FOREIGN KEY (`userID`) REFERENCES `User`(`userID`);

ALTER TABLE `User-Category` ADD CONSTRAINT `User-Category_fk1` FOREIGN KEY (`categoryID`) REFERENCES `Category`(`categoryID`);
