ALTER TABLE passenger
    ADD active_booking_id BIGINT NULL;

ALTER TABLE passenger
    ADD exact_location_id BIGINT NULL;

ALTER TABLE passenger
    ADD home_id BIGINT NULL;

ALTER TABLE passenger
    ADD rating DOUBLE NULL;

ALTER TABLE booking
    ADD end_location_id BIGINT NULL;

ALTER TABLE booking
    ADD start_location_id BIGINT NULL;

ALTER TABLE driver
    ADD is_available BIT(1) NULL;

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_ENDLOCATION FOREIGN KEY (end_location_id) REFERENCES exact_location (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_STARTLOCATION FOREIGN KEY (start_location_id) REFERENCES exact_location (id);

ALTER TABLE passenger
    ADD CONSTRAINT FK_PASSENGER_ON_ACTIVEBOOKING FOREIGN KEY (active_booking_id) REFERENCES booking (id);

ALTER TABLE passenger
    ADD CONSTRAINT FK_PASSENGER_ON_EXACTLOCATION FOREIGN KEY (exact_location_id) REFERENCES exact_location (id);

ALTER TABLE passenger
    ADD CONSTRAINT FK_PASSENGER_ON_HOME FOREIGN KEY (home_id) REFERENCES exact_location (id);
