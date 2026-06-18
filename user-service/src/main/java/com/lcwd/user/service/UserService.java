package com.lcwd.user.service;

import com.lcwd.user.entities.User;


import java.util.List;

public interface UserService {

    User saveUser(User user);

    User getUser(String userId);

    List<User> getAllUsers();

    User updateUser(User user, String userId);

    void deleteUser(String userId);


}