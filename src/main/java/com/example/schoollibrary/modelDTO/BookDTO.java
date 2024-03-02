package com.example.schoollibrary.modelDTO;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    Integer id;
    String bookName;
    String author;
    String pubHouse;
    Date year;
    Date createdAt;
    String flag;

//    BookDTO() {
//    }

    public BookDTO(Integer id, String bookName, String author, String pubHouse, Date year, Date createdAt, String flag) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.pubHouse = pubHouse;
        this.year = year;
        this.createdAt = createdAt;
        this.flag = flag;

    }
}
