package com.sruchko.user.controller;

import com.sruchko.user.model.dto.register.UserRegister;
import com.sruchko.user.model.dto.register.UserUpdate;
import com.sruchko.user.model.dto.responce.UserResponse;
import com.sruchko.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Validated UserRegister userRegister) {

        UserResponse userResponse = userService.create(userRegister);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userResponse);
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity<UserResponse> update(@RequestBody @Validated UserUpdate userupdate) throws Exception {

        UserResponse userResponse = userService.update(userupdate);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(userResponse);
    }

    @GetMapping("/{uuid}")
    public UserResponse getUser(@PathVariable("uuid") UUID uuid) throws Exception {

        return userService.getById(uuid);
    }

    @GetMapping("/email")
    public UserResponse getByUserEmail(@PathVariable("email") String email) throws Exception {

        return userService.getByUserEmail(email);
    }
}
