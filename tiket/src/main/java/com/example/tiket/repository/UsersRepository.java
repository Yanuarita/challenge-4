package com.example.tiket.repository;

import com.example.tiket.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    @Query(value = "SELECT * FROM public.users WHERE password = 1 ORDER BY emailAddress DESC LIMIT 50", nativeQuery = true)
    List<Users> findByUsersPasswordDesc();


    List<Users> findByUserName(String name);

}