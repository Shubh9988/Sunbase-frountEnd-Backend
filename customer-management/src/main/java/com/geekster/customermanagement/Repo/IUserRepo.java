package com.geekster.customermanagement.Repo;


import com.geekster.customermanagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
