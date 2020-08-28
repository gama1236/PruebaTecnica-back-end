package com.pruebatecnica.codesa.controllers;

import com.pruebatecnica.codesa.model.Rol;
import com.pruebatecnica.codesa.responses.SimpleResponse;
import com.pruebatecnica.codesa.services.implementes.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rol")
@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RolController {

    private final IRolService iRolService;

    @Autowired
    public RolController(IRolService iRolService){
        this.iRolService = iRolService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<SimpleResponse> getAllRols(){

        List<Rol> rols = iRolService.getAll();
        SimpleResponse simpleResponse = SimpleResponse.builder().code(200).message("Exito obteniendo los datos").value(rols).build();
        return new ResponseEntity<>(simpleResponse, HttpStatus.OK);


    }

}
