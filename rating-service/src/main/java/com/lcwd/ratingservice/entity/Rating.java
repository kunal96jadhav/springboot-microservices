package com.lcwd.ratingservice.entity;


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

    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;


}
