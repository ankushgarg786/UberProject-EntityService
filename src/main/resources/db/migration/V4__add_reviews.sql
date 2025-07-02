CREATE TABLE passenger_review
(
    id                       BIGINT       NOT NULL,
    passenger_review_content VARCHAR(255) NOT NULL,
    passenger_rating         VARCHAR(255) NOT NULL,
    CONSTRAINT pk_passengerreview PRIMARY KEY (id)
);

ALTER TABLE driver
    ADD active_city VARCHAR(255) NULL;

ALTER TABLE driver
    ADD driver_approval_status ENUM('APPROVED','DENIED','PENDING') NULL;

ALTER TABLE driver
    ADD home_id BIGINT NULL;

ALTER TABLE driver
    ADD last_known_location_id BIGINT NULL;

ALTER TABLE driver
    ADD phone_number VARCHAR(255) NULL;

ALTER TABLE driver
    ADD rating DOUBLE NULL;

ALTER TABLE driver
    MODIFY phone_number VARCHAR (255) NOT NULL;

ALTER TABLE driver
    ADD CONSTRAINT uc_driver_phonenumber UNIQUE (phone_number);

ALTER TABLE driver
    ADD CONSTRAINT FK_DRIVER_ON_HOME FOREIGN KEY (home_id) REFERENCES exact_location (id);

ALTER TABLE driver
    ADD CONSTRAINT FK_DRIVER_ON_LASTKNOWNLOCATION FOREIGN KEY (last_known_location_id) REFERENCES exact_location (id);

ALTER TABLE passenger_review
    ADD CONSTRAINT FK_PASSENGERREVIEW_ON_ID FOREIGN KEY (id) REFERENCES booking_review (id);

ALTER TABLE driver
    ADD CONSTRAINT check_rating CHECK ( driver.rating >=0 AND driver.rating <=5 )