package com.blog.services;


import com.blog.payload.UserDto;


import java.util.List;
import java.util.Optional;


public interface UserServices {

     UserDto addUsr(UserDto user);

     List<UserDto> getAllUser();

     Optional<UserDto> getUserById(int id);

     UserDto updateUser(UserDto user,int id);

     void deleteUser(int id);
}
