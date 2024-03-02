package com.example.schoollibrary.repository;

import com.example.schoollibrary.modelEntity.Book;
import com.example.schoollibrary.modelEntity.User;
import com.example.schoollibrary.modelEntity.Usersbooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository interface for {@link com.example.schoollibrary.modelEntity.User} class.
 */
public interface UsersbooksRepository extends JpaRepository<Usersbooks, Integer> {

    //@Query("SELECT u FROM User u WHERE u.id = :id")
    //@Query("select distinct ub.user, count(ub.dateTake), count(ub.datePut), ub.book from Usersbooks ub where ub.user.id = :id")
    //@Query("select distinct ub.user, ub, ub.book from Usersbooks ub where ub.user.id = :id")
    //@Query("select distinct ub.user, ub from Usersbooks ub where ub.user.id = :id")
    //@Query("select distinct ub, Usersbooks from User ub where ub.id = :id")
    @Query("select ub, Usersbooks from User ub where ub.id = :id")
    User findUserInfoById(@Param("id") Integer id);

    @Query("select Book, Usersbooks from Usersbooks")
    Usersbooks findMostPopularBooks();

}
