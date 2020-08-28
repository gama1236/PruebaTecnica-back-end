package com.pruebatecnica.codesa.services;

import com.pruebatecnica.codesa.exceptions.ExistInDataBaseException;
import com.pruebatecnica.codesa.exceptions.NotExistThisIdException;
import com.pruebatecnica.codesa.model.User;
import com.pruebatecnica.codesa.repository.UserRepository;
import com.pruebatecnica.codesa.services.implementes.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        if (userRepository.existsByUserName(user.getUserName())) {
            throw new ExistInDataBaseException("El nombre ya esta registrado, intente con otro");
        }

        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User userx = userRepository.findByUserId(user.getUserId());
        if (userx.getUserName().equals(user.getUserName())){
            return userRepository.save(user);
        }
        return saveUser(user);
    }

    @Override
    public List<User> getallUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {

        if(!userRepository.existsByUserId(id)){
            throw  new NotExistThisIdException("El id que desea borrar no existe");
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findByUserNameLike(String name) {
        return userRepository.findByUserNameContaining(name);
    }
}
