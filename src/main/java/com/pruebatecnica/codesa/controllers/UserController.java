package com.pruebatecnica.codesa.controllers;

import com.pruebatecnica.codesa.exceptions.ExistInDataBaseException;
import com.pruebatecnica.codesa.exceptions.NotExistThisIdException;
import com.pruebatecnica.codesa.model.User;
import com.pruebatecnica.codesa.model.request.UserRequest;
import com.pruebatecnica.codesa.responses.SimpleResponse;
import com.pruebatecnica.codesa.services.implementes.IUserService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "User Rest API")
public class UserController {

    private static final ModelMapper modelMapper = new ModelMapper();

    private final IUserService userService;

    @Autowired
    public UserController(IUserService iUserService){
        this.userService= iUserService;
    }

    @PostMapping("/insert")
    public ResponseEntity<SimpleResponse> saveUser(@RequestBody UserRequest userRequest) {
        SimpleResponse simpleResponse;
        try {
            User user = modelMapper.map(userRequest, User.class);
            User result = userService.saveUser(user);
            simpleResponse = SimpleResponse.builder().code(200).message("Se ha creado correctamente").value(result).build();
        }catch (ExistInDataBaseException e) {
            simpleResponse = SimpleResponse.builder().code(400).message(e.getMessage()).value(null).build();
        }
        return  new ResponseEntity<>(simpleResponse,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<SimpleResponse> updateUser(@RequestBody UserRequest userRequest) {
        SimpleResponse simpleResponse;
        try {
            User user = modelMapper.map(userRequest, User.class);
            User result = userService.updateUser(user);
            simpleResponse = SimpleResponse.builder().code(200).message("Se ha actualizado correctamente").value(result).build();

        }catch (Exception e) {
            simpleResponse = SimpleResponse.builder().code(400).message("Ha ocurrido un error").value(null).build();
        }

        return  new ResponseEntity<>(simpleResponse,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<SimpleResponse> getAllUsers() {
        List<User> resultUser =  userService.getallUsers();
        SimpleResponse simpleResponse = SimpleResponse.builder().code(200).message("Exito obteniendo los datos").value(resultUser).build();
        return new ResponseEntity<>(simpleResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SimpleResponse> deleteUser(@PathVariable Long id) {
        SimpleResponse response;
        try{
            userService.deleteUser(id);
            response = SimpleResponse.builder().code(200).message("Se borro el usuario con exito ").build();

        }catch (NotExistThisIdException e){
            response =  SimpleResponse.builder().code(400).message(e.getMessage()).value(null).build();
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
