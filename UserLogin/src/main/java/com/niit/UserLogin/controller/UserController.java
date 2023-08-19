/*
 * Author Name: Aakash Kaushik
 * Date: 13-12-2022
 * Createdd with IntelliJ IDEA Community Editiion
 */
package com.niit.UserLogin.controller;

import com.niit.UserLogin.domain.User;
import com.niit.UserLogin.exception.UserNotFoundException;
import com.niit.UserLogin.service.IUserService;
import com.niit.UserLogin.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class UserController {
    private IUserService iUserService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(IUserService iUserService,SecurityTokenGenerator securityTokenGenerator) {
        this.iUserService = iUserService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveFunc(@RequestBody User user)
    {
        return new ResponseEntity<>(iUserService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/fetchall")
    public ResponseEntity<?> fetchFunc(){
        return new ResponseEntity<>(iUserService.getAllUsers(),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginFunc(@RequestBody User user) throws UserNotFoundException {
        try {
            iUserService.loginCheck(user.getUsername(), user.getPassword());
            Map<String,String> secretkey = new HashMap<>();
            secretkey = securityTokenGenerator.generateToken(user);
            return new ResponseEntity<>(secretkey,HttpStatus.OK);
        }catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Network Error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fetchuserbyusername/{username}")
    public ResponseEntity<?> fetchFunc2(@PathVariable String username){
        return new ResponseEntity<>(iUserService.getByUsername(username), HttpStatus.FOUND);

    }

    @DeleteMapping("/deleteuserbyusername/{username}")
    public ResponseEntity<?> deleteFunc(@PathVariable String username){
        return new ResponseEntity<>(iUserService.delByUsername(username), HttpStatus.OK);
    }

}
