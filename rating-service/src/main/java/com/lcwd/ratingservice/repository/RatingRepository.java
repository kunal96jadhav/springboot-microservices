package com.lcwd.ratingservice.repository;
import com.lcwd.ratingservice.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
public interface RatingRepository extends MongoRepository<Rating, String>{

    // Get ratings by userId
    List<Rating> findByUserId(String userId);

    // Get ratings by hotelId
    List<Rating> findByHotelId(String hotelId);
}
