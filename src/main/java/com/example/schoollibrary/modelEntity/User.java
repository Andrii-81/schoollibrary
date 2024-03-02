package com.example.schoollibrary.modelEntity;

import jakarta.persistence.*;
// import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "adress")
    private String adress;

    @Column(name = "created_at")
    private Date createdAt;

    @ToString.Exclude
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "usersbooks",
//            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "book_id",  referencedColumnName = "id")}
//    )
    @OneToMany(mappedBy = "user")
    //private List<Book> books = new ArrayList<>();
    private List<Usersbooks> usersbooks = new ArrayList<>();


    public User() {
    }
//    public User(int id, String firstName, String lastName, Date birthday, String phoneNumber, String email,
//                String adress, Date createdAt, List<Book> books) {

    public User(Integer id, String firstName, String lastName, Date birthday, String phoneNumber, String email,
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
    public User(Integer id, String firstName, String lastName, Date birthday, String phoneNumber, String email,
                String adress, Date createdAt, List<Usersbooks> usersbooks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adress = adress;
        this.createdAt = createdAt;
        //this.book = book;
        this.usersbooks = usersbooks;
    }

//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }
        public void setUserbooks(List<Usersbooks> usersbooks) {
        this.usersbooks = usersbooks;
    }

}
