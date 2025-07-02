package org.uberprojectentityservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = {
        @Index(columnList = "driver_id")
})
public class Booking extends BaseModel{

    @OneToOne(mappedBy = "booking", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) //cascade = {PERSIST, REMOVE} means: When a Booking is saved, its Review is also saved.,When a Booking is deleted, its Review is also deleted.
    private Review review; // we have defined a 1:1 relationship between booking and review

    @Enumerated(value = EnumType.STRING)
    @Column(name = "booking_status")
    private BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totalDistance;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;

    @OneToOne
    private ExactLocation startLocation;

    @OneToOne
    private ExactLocation endLocation;

}