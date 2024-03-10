package com.sruchko.user.service;

import com.sruchko.user.model.User;
import com.sruchko.user.model.UserMapper;
import com.sruchko.user.model.dto.register.UserRegister;
import com.sruchko.user.model.dto.register.UserUpdate;
import com.sruchko.user.model.dto.responce.UserResponse;
import com.sruchko.user.repository.UserRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse create(UserRegister userRegister) {
        User user = UserMapper.mapToUser(userRegister);
        User saveduser = userRepository.save(user);
        return UserMapper.mapToUserResponse(saveduser);
    }

    public UserResponse update(UserUpdate userupdate) throws Exception {

        User user = userRepository.findById(userupdate.getId())
                .orElseThrow( () -> new Exception("Invalid user with uuid: %s".formatted(userupdate.getId())));


        user.setFirstName(userupdate.getFirstName());
        user.setLastName(userupdate.getLastName());
        user.setEmail(userupdate.getEmail());
        user.setPhoneNumber(userupdate.getPhoneNumber());

        userRepository.save(user);

        return UserMapper.mapToUserResponse(user);

    }

    public UserResponse getById(UUID uuid) throws Exception {

        Optional<User> user = userRepository.findById(uuid);

        if (user.isEmpty()) throw new Exception("Invalid user with uuid: %s".formatted(uuid));

        return UserMapper.mapToUserResponse(user.get());

    }

    public UserResponse getByUserEmail(String email) throws Exception {

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) throw new Exception("Invalid user with uuid: %s".formatted(email));

        return UserMapper.mapToUserResponse(user.get());
    }
}
