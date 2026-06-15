package com.lcwd.ratingservice.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "ratings")
public class Rating {

    @Id
    private String ratingId;

    @NotBlank(message = "User Id is required")
    private String userId;

    @NotBlank(message = "Hotel Id is required")
    private String hotelId;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating cannot be greater than 5")
    private int rating;

    @NotBlank(message = "Feedback is required")
    private String feedback;
}