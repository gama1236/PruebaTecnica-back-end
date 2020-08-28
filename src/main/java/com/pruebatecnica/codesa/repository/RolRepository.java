package com.pruebatecnica.codesa.repository;

import com.pruebatecnica.codesa.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long> {

}
