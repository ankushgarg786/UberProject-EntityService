package org.uberprojectentityservice.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DBConstants extends BaseModel {
    @Column(nullable = false,unique = true)
    private String name;

    private String value;
}
