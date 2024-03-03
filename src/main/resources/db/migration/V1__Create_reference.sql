CREATE TABLE reference (
    code VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    description TEXT,
    price_per_day INT NOT NULL
);

CREATE TABLE reference_characteristic (
    code VARCHAR(36),
    characteristic VARCHAR(255),
    characteristic_value TEXT,
    PRIMARY KEY (code, characteristic),
    FOREIGN KEY (code) REFERENCES reference(code) ON DELETE CASCADE
);
