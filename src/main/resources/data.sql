INSERT INTO USER_INFORMATION (ID_USER_INFORMATION, FIRST_NAME, LAST_NAME, BIRTH_DATE, EMAIL_ADDRESS)
VALUES (1, 'Pilar', 'Arriola', '1991-02-14', 'pilararriola1@gmail.com'),
(2, 'Demo', 'User', '1983-07-24', 'demouser@gmail.com');

INSERT INTO USER_AUTH (ID_USER_AUTH, USER_NAME, PASSWORD, SALT, ID_USER_INFORMATION)
VALUES (1, 'pilararriola', 'dpgBN6Tz2djzg4R7SF2LFnfGzBKYq1L97iRm53IazTs=', '7s9jEBsoOYF421dNcTvOoDQ98HMuNP', 1),
(2, 'demouser', 'li2PN5LC2iVF24/rVWRuUyY7a1XL2E1hb9zk/gdaX4o=', 'Dafl8fKEE1i8EdAaCNtVqdUOCNNJyO', 2);