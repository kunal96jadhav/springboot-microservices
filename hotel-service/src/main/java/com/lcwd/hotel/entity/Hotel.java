package com.lcwd.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {

    @Id
    private String id;

    @NotBlank(message = "Hotel name is required")
    @Size(min = 3, message = "Hotel name must be at least 3 characters")
    private String name;

    @NotBlank(message = "Hotel location is required")
    private String location;

    @NotBlank(message = "Hotel about is required")
    private String about;
}