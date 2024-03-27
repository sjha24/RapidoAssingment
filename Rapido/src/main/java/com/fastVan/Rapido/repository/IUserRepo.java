package com.fastVan.Rapido.repository;

import com.fastVan.Rapido.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
