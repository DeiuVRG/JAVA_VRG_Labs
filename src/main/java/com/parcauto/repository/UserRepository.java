package com.parcauto.repository;

import com.parcauto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUtilizator(String utilizator);
}
