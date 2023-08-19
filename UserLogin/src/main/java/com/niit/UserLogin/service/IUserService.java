package com.niit.UserLogin.service;

import com.niit.UserLogin.domain.User;
import com.niit.UserLogin.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public User loginCheck(String username, String password) throws UserNotFoundException;
    public User getByUsername(String username);
    public boolean delByUsername(String username);
}
