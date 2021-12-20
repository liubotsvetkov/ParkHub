package com.example.parkhub.userAccessModule.data.springData.repositories;

import com.example.parkhub.userAccessModule.data.springData.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUsername(String username);
}
