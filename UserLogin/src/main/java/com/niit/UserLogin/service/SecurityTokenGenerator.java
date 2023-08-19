package com.niit.UserLogin.service;

import com.niit.UserLogin.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {

    Map<String,String> generateToken(User user);
}
