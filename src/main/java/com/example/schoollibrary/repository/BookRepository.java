package com.example.schoollibrary.repository;

import com.example.schoollibrary.modelEntity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository interface for {@link com.example.schoollibrary.modelEntity.Book} class.
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

    //@Query("SELECT b FROM Usersbooks u INNER JOIN Book b WHERE b.id = :id")
    //@Query("SELECT b FROM Book b, Usersbooks u WHERE b.id = :id")
    @Query("SELECT b FROM Book b WHERE b.id = :id")
    Book findBookById(@Param("id") Integer id);

    @Query("SELECT b FROM Book b")
    List<Book> findAll();
}
