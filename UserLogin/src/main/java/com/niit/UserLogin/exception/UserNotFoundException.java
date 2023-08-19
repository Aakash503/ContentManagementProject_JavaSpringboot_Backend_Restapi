/*
 * Author Name: Aakash kaushik
 * Date: 29-11-2022
 * Createdd with IntelliJ IDEA Community Editiion
 */
package com.niit.UserLogin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Login Failed!! Invalid username or password")
public class UserNotFoundException extends Exception{
}
