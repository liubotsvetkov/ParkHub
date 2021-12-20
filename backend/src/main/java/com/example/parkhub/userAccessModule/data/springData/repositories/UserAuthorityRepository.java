package com.example.parkhub.userAccessModule.data.springData.repositories;

import com.example.parkhub.userAccessModule.data.springData.entities.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Integer> {
}
