package com.example.schoollibrary.modelDTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Data
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String phoneNumber;
    private String email;
    private String adress;
    private Date createdAt;


    private Integer bookRead;
    private Integer bookInProgress;
    //private List<BookDTO> bookListInfo;

    private Date lastDateTakedBookFromLibrary;


    public UserInfoDTO (Integer id, String firstName, String lastName, Date birthday, String phoneNumber, String email,
                    String adress, Date createdAt, Integer bookRead, Integer bookInProgress, Date lastDateTakedBookFromLibrary) {
            //, List<BookDTO> bookListInfo) {
        //,  Date lastDatetakedBookFromLibrary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adress = adress;
        this.createdAt = createdAt;
        this.bookRead = bookRead;
        this.bookInProgress = bookInProgress;
        //this.bookListInfo = bookListInfo;
        this.lastDateTakedBookFromLibrary = lastDateTakedBookFromLibrary;
    }
}
