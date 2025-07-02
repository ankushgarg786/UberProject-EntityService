package org.uberprojectentityservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends BaseModel{

    private String name;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @Column(nullable = false,unique = true)
    private String phoneNumber;

    private String aadharCard;

    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    private Car car;

    @Enumerated(value = EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation home;

    private String activeCity;

    private Boolean isAvailable;

    @DecimalMin(value = "0.00",message = "Rating must be greater than or equal to 0")
    @DecimalMax(value = "5.00",message = "Rating must be less than or equal to 5.0")
    private Double rating;

    // 1 : n , Driver : Booking
    @OneToMany(mappedBy = "driver",fetch = FetchType.LAZY)  //The mappedBy = "driver" points to the field in the Booking entity that owns the relationship:,// One driver can be assigned to multiple bookings
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings = new ArrayList<>();
}