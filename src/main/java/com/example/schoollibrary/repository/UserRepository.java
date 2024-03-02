package com.example.schoollibrary.repository;

import com.example.schoollibrary.modelEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository interface for {@link com.example.schoollibrary.modelEntity.User} class.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.id = :id")
    User findUserById(@Param("id") Integer id);

    @Query("SELECT u FROM User u")
    List<User> findAll();
}
