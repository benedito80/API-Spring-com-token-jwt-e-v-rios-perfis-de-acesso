package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.dao.UserDAO;

import java.util.List;

public interface IUserService {

    User save(UserDAO user);

    List<User> findAll();

    void delete(long id);

    User findOne(String username);

    User findById(Long id);
}
