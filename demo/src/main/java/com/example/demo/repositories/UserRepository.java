package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    public User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.address = :address")
    List<User> findByAddress(String address);
}
