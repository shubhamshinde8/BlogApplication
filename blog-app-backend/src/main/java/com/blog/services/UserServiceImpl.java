package com.blog.services;

import com.blog.exception.ResourceNotFoundException;
import com.blog.model.User;
import com.blog.payload.UserDto;
import com.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto addUsr(UserDto userDto) {

        User user=this.dtoToUser(userDto);
        User savedUser=userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users=this.userRepository.findAll();
        List<UserDto> userDtos=users.stream().
                map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user=this.userRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("user","id",id));
        return this.userToDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto,Integer id) {

        User user=userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User","Id",id));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());

        User updatedUser=userRepository.save(user);
        return this.userToDto(updatedUser);
    }

    @Override
    public void deleteUser(Integer id) {
        User user=this.userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("user","id",id));

        this.userRepository.delete(user);
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
