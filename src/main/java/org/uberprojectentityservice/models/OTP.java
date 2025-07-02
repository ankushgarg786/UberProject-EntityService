package org.uberprojectentityservice.models;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Random;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OTP extends BaseModel{

    private String code;

    private String sentToNumber;

    /**
     *
     * @param phoneNumber
     * @return random otp
     */
    public static OTP make(String phoneNumber){
        Random random = new Random();
        Integer code=random.nextInt(9000)+1000;

        return OTP.builder().sentToNumber(phoneNumber).code(code.toString()).build();
    }
}
