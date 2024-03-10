package com.sruchko.user.model.dto.register;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRegister {
    @NotNull
    private String firstName;
    @NotNull
    @Column(nullable = false)
    private String lastName;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;

}
