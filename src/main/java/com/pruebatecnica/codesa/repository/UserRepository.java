package com.pruebatecnica.codesa.repository;

import com.pruebatecnica.codesa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserName(String name);
    boolean existsByUserId(Long id);
    User findByUserId(Long id);
    List<User> findByUserNameContaining(String name);
}
