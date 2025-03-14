package com.blog.services;

import com.blog.model.User;
import com.blog.payload.UserDto;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServices{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto addUsr(UserDto user) {

        UserDto user1=userRepository.save(user);
        return user1;
    }

    @Override
    public List<UserDto> getAllUser() {

        List<UserDto> users=userRepository.findAll();
        return users;
    }

    @Override
    public Optional<UserDto> getUserById(int id) {
        Optional<UserDto> user=userRepository.findById(id);
        return user;
    }

    @Override
    public UserDto updateUser(UserDto userDto,int id) {
        return null;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    private User dtoToUser(UserDto userDto){
        User user=new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;
    }

    private UserDto userToDto(User user){
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }
}
