CREATE DATABASE accountinfo;

USE accountinfo;

CREATE TABLE Accounts
(
	AccountID varchar(30) NOT NULL,
	PIN int NOT NULL,
	CardNo int NOT NULL,
    CustomerEmail varchar(30) NOT NULL
);
CREATE TABLE OrderInfo
(
	AccountID varchar(30) NOT NULL,
    Item varchar(30) NOT NULL,
    Quantity int NOT NULL,
	TotalPrice double NOT NULL,
    AuthorizationNo int NOT NULL
);	

USE accountinfo;
INSERT INTO Accounts (AccountID, PIN, CardNo, CustomerEmail) VALUES ('steve', 2345, 12345678, 'steve@ttu.edu');
INSERT INTO Accounts (AccountID, PIN, CardNo, CustomerEmail) VALUES ('alex', 4567, 23456789, 'alex@ttu.edu');
INSERT INTO Accounts (AccountID, PIN, CardNo, CustomerEmail) VALUES ('jane', 6789, 45678901, 'jane@ttu.edu');
INSERT INTO Accounts (AccountID, PIN, CardNo, CustomerEmail) VALUES ('john', 5678, 56789012, 'john@ttu.edu');
INSERT INTO Accounts (AccountID, PIN, CardNo, CustomerEmail) VALUES ('sam', 7890, 89012345, 'sam@ttu.edu');

INSERT INTO OrderInfo (AccountID, Item, Quantity, TotalPrice, AuthorizationNo) Values('alex', 'note', 3, 20.00, 3333);
INSERT INTO OrderInfo (AccountID, Item, Quantity, TotalPrice, AuthorizationNo) Values('john', 'book', 1, 50.00, 5555);
INSERT INTO OrderInfo (AccountID, Item, Quantity, TotalPrice, AuthorizationNo) Values('sam', 'pencil', 20, 10.00, 7777);