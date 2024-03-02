package com.example.schoollibrary.modelDTO;

//import com.example.schoollibrary.modelEntity.Usersbooks;
//import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String phoneNumber;
    private String email;
    private String adress;
    private Date createdAt;
    public UserDTO (Integer id, String firstName, String lastName, Date birthday, String phoneNumber, String email,
                String adress, Date createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adress = adress;
        this.createdAt = createdAt;
    }

}
