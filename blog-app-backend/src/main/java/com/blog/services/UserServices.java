package com.blog.services;


import com.blog.payload.UserDto;


import java.util.List;
import java.util.Optional;


public interface UserServices {

     UserDto addUsr(UserDto user);

     List<UserDto> getAllUsers();

     UserDto getUserById(Integer id);

     UserDto updateUser(UserDto user,Integer id);

     void deleteUser(Integer id);
}
