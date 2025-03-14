package com.blog.controller;


import com.blog.payload.UserDto;
import com.blog.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/apis/user")
public class UserController  {

    @Autowired
    private UserServices userServices;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto newUser=this.userServices.addUsr(userDto);

        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }
}
