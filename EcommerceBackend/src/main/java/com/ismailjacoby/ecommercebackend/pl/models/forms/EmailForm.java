package com.ismailjacoby.ecommercebackend.pl.models.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class EmailForm {
    @Email(message = "Invalid email format.")
    @NotBlank(message = "Email is required.")
    private String email;
}
