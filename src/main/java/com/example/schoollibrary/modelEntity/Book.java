package com.example.schoollibrary.modelEntity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "author")
    private String author;

    @Column(name = "pub_house")
    private String pubHouse;

    @Column(name = "year")
    private Date year;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "flag")
    private String flag;

    //@ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "book")

    //private List<User> users = new ArrayList<>();
    private List<Usersbooks> usersbooks = new ArrayList<>();

    public Book() {
    }

//    public Book(int id, String bookName, String author, String pubHouse, Date year, Date createdAt, String flag, List<User> users) {
    public Book(Integer id, String bookName, String author, String pubHouse, Date year, Date createdAt, String flag, List<Usersbooks> usersbooks) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.pubHouse = pubHouse;
        this.year = year;
        this.createdAt = createdAt;
        this.flag = flag;
        //this.users = users;
        this.usersbooks = usersbooks;
    }

    public Book(Integer id, String bookName, String author, String pubHouse, Date year, Date createdAt, String flag) { //}, List<Usersbooks> usersbooks) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.pubHouse = pubHouse;
        this.year = year;
        this.createdAt = createdAt;
        this.flag = flag;
        //this.users = users;
        //this.usersbooks = usersbooks;
    }

    public void setUserbooks(List<Usersbooks> usersbooks) {
        this.usersbooks = usersbooks;
    }


}