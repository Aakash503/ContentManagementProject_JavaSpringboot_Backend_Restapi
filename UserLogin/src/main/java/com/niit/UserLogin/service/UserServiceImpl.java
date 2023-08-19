/*
 * Author Name: Aakash kaushik
 * Date: 13-12-2022
 * Createdd with IntelliJ IDEA Community Editiion
 */
package com.niit.UserLogin.service;

import com.niit.UserLogin.domain.User;
import com.niit.UserLogin.exception.UserNotFoundException;
import com.niit.UserLogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User loginCheck(String username, String password) throws UserNotFoundException {
        User userObj = userRepository.findByUsernameAndPassword(username,password);
        if(userObj==null){
            throw new UserNotFoundException();
        }
        return userObj;
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean delByUsername(String username) {
        userRepository.deleteByUsername(username);
        return true;
    }


}
