CREATE TABLE shelving(
    shelvingId INT auto_increment NOT NULL,
    name VARCHAR (50) NOT NULL,
    CONSTRAINT pk_shelvingId PRIMARY KEY(shelvingId)
);


CREATE TABLE component(
    componentId INT auto_increment NOT NULL,
    shelvingId INT NOT NULL,
    description VARCHAR (200) NOT NULL,
    salePrice DECIMAL(10,2) NULL,
    CONSTRAINT pk_componentId PRIMARY KEY(componentId),
    CONSTRAINT fk_shelvingId FOREIGN KEY (shelvingId) REFERENCES shelving(shelvingId)
    ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE formedBy (
    componentIdA INT,
    componentIdB INT,
    PRIMARY KEY (componentIdA, componentIdB),
    FOREIGN KEY (componentIdA) REFERENCES component(componentId),
    FOREIGN KEY (componentIdB) REFERENCES component(componentId)
    ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE deposit (
    depositId INT auto_increment NOT NULL,
    description VARCHAR(255) NULL,
    address VARCHAR(255) NOT NULL,
    CONSTRAINT pk_depositId PRIMARY KEY(depositId)
);


CREATE TABLE contain (
    shelvingId INT,
    depositId INT,
    PRIMARY KEY (shelvingId, depositId),
    CONSTRAINT fk_shelvingId1 FOREIGN KEY (shelvingId) REFERENCES shelving(shelvingId),
    CONSTRAINT fk_depositId1 FOREIGN KEY (depositId) REFERENCES deposit(depositId)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE store (
    componentId INT,
    depositId INT,
    amount INT,
    PRIMARY KEY (componentId, depositId),
	CONSTRAINT fk_componentId1 FOREIGN KEY (componentId) REFERENCES component(componentId),
    CONSTRAINT fk_depositId2 FOREIGN KEY (depositId) REFERENCES deposit(depositId)
	ON DELETE CASCADE ON UPDATE CASCADE
);


