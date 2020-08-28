package com.pruebatecnica.codesa.services.implementes;

import com.pruebatecnica.codesa.model.User;

import java.util.List;

public interface IUserService {

    User saveUser(User user);

    User updateUser(User user);

    List<User> getallUsers();

    void deleteUser(Long id);

    List<User> findByUserNameLike(String name);

}
