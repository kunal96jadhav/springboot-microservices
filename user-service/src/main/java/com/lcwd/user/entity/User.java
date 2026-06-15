package com.lcwd.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.Transient;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String userId;

    private String name;

    private String email;

    private String about;

    @Transient
    private List<Rating> ratings;

}