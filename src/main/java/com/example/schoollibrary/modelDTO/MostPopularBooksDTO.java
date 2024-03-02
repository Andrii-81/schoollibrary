package com.example.schoollibrary.modelDTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor

public class MostPopularBooksDTO {
    private Integer id;
    private String bookName;
    private String author;
    private String pubHouse;
    private Date year;
    private Date createdAt;
    private String flag;

    private Date dateTake;
    private Date datePut;

    public MostPopularBooksDTO(Integer id, String bookName, String author, String pubHouse, Date year,
                               Date createdAt, String flag, Date dateTake, Date datePut) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.pubHouse = pubHouse;
        this.year = year;
        this.createdAt = createdAt;
        this.flag = flag;
        this.dateTake = dateTake;
        this.datePut = datePut;
    }
}
