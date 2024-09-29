package com.user.registration.service;


import com.user.registration.dto.UserDto;
import com.user.registration.mappers.UserMapper;
import com.user.registration.model.User;
import com.user.registration.model.Phone;
import com.user.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;


@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;


    public User createUser(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.email())) {
            throw new RuntimeException("El correo ya registrado");
        }

        return userRepository.save(userMapper.toEntity(userDto, generateToken()));
    }

    private String generateToken() {
        // Implement JWT token generation
        return java.util.UUID.randomUUID().toString();
    }
}


