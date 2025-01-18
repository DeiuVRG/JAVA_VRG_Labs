CREATE TABLE IF NOT EXISTS masinidb (
                                    license_plate VARCHAR(20) PRIMARY KEY,
    brand VARCHAR(50),
    year INT,
    color VARCHAR(20),
    kilometers INT
    );

INSERT INTO masinidb (license_plate, brand, year, color, kilometers) VALUES
                                                                     ('TM01AAA', 'Toyota', 2020, 'Red', 50000),
                                                                     ('AR02BBB', 'Ford', 2018, 'Blue', 80000),
                                                                     ('BH03CCC', 'BMW', 2019, 'Black', 70000),
                                                                     ('CJ04DDD', 'Mercedes', 2021, 'White', 30000),
                                                                     ('TM05EEE', 'Audi', 2022, 'Gray', 10000);
