package com.sruchko.user.model;


import com.sruchko.user.model.dto.register.UserRegister;
import com.sruchko.user.model.dto.responce.UserResponse;

public class UserMapper {

    public static User mapToUser(UserRegister userRegister) {

        return User.builder()
                .firstName(userRegister.getFirstName())
                .lastName(userRegister.getLastName())
                .email(userRegister.getEmail())
                .phoneNumber(userRegister.getPhoneNumber())
                .build();
    }

    public static UserResponse mapToUserResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .tasks(user.getTasks())
                .build();
    }


}
