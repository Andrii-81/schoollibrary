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
@Table(name = "usersbooks")
public class Usersbooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    @Column(name = "date_take")
    private Date dateTake;

    @Column(name = "date_put")
    private Date datePut;

    public Usersbooks() {}

    public Usersbooks(Integer id, User user, Book book, Date dateTake, Date datePut) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.dateTake = dateTake;
        this.datePut = datePut;
    }

}
