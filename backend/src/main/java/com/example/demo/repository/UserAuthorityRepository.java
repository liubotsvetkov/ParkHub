package com.example.demo.repository;

import com.example.demo.models.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Integer> {
    //List<Person> findByTitleContainingOrContentContaining(String text, String textAgain);
}
