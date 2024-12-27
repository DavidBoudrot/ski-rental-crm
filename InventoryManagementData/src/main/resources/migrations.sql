CREATE TABLE snowboard (
    snowboardId BIGINT PRIMARY KEY AUTO_INCREMENT,
    color VARCHAR(255),
    snowboardLength INT,
    stiffnessRating INT,
    isSymmetrical BOOLEAN
);
CREATE TABLE skis (
    skisId BIGINT PRIMARY KEY AUTO_INCREMENT,
    color VARCHAR(255),
    skisLength INT,
    stiffnessRating INT
);
CREATE TABLE rentals (
    rentalId BIGINT NOT NULL PRIMARY KEY,
    userId BIGINT,
    rentalDate BIGINT NOT NULL,
    expectedReturnDate BIGINT NOT NULL,
    actualReturnDate BIGINT
);
CREATE TABLE snowboard_rental (
    rentalId BIGINT,
    snowboardId BIGINT,
    FOREIGN KEY (rentalId) REFERENCES rentals(rentalId),
    FOREIGN KEY (snowboardId) REFERENCES snowboard(snowboardId),
    PRIMARY KEY (rentalId, snowboardId)
);
CREATE TABLE skis_rental (
    rentalId BIGINT,
    skisId INT,
    FOREIGN KEY (rentalId) REFERENCES rentals(rentalId),
    FOREIGN KEY (skisId) REFERENCES skis(skisId),
    PRIMARY KEY (rentalId, skisId)
);