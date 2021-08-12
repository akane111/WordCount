package com.gaoge.service;

import com.gaoge.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectAll();

    void add(User user);

    void update(User user);

    void delete(String userName);

    void selectByUserName(String userName);
}
