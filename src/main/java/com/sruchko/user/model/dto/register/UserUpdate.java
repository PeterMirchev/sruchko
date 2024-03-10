package com.sruchko.user.model.dto.register;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class UserUpdate {
    @NotNull(message = "required UUID")
    private UUID id;
    @NotNull(message = "required first name")
    private String firstName;
    @NotNull(message = "required last name")
    @Column(nullable = false)
    private String lastName;
    @Email
    @NotNull(message = "required email")
    private String email;
    @NotNull(message = "required phone number")
    private String phoneNumber;
}
