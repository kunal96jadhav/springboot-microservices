package com.lcwd.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.Transient;
import java.util.List;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String userId;

    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;

    @Email(message = "Email address is not valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "About is required")
    private String about;

    @Transient
    private List<Rating> ratings;

}