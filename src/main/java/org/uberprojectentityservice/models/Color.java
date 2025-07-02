package org.uberprojectentityservice.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Color extends BaseModel{
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "color",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Car> car;
}
