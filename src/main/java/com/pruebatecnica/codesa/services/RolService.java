package com.pruebatecnica.codesa.services;

import com.pruebatecnica.codesa.model.Rol;
import com.pruebatecnica.codesa.repository.RolRepository;
import com.pruebatecnica.codesa.services.implementes.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService implements IRolService {

    private final RolRepository rolRepository;

    @Autowired
    public RolService (RolRepository rolRepository){
        this.rolRepository = rolRepository;
    }
    @Override
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }
}
