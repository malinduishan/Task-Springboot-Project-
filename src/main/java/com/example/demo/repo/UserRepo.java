package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {




    @Query(value = "SELECT * FROM `user` WHERE id = ?1",nativeQuery = true)
    User getUserByUserId(String userId);

    @Query(value = "SELECT * FROM `user` WHERE id = ?1 AND fname = ?2",nativeQuery = true)
    User getUserByIdAndFname(String userId, String fname);

//    update query ekak gahanawanm @modifying kiyana annotation eka use karanna one query ekata kalin
//    @Modifying
//    @Query(value = " ......

}
