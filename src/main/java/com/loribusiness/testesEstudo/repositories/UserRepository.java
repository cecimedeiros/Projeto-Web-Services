package com.loribusiness.testesEstudo.repositories;

import com.loribusiness.testesEstudo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
