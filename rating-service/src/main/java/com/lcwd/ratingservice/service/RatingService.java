package com.lcwd.ratingservice.service;

import com.lcwd.ratingservice.entity.Rating;
import java.util.List;

public interface RatingService {

    // Create Rating
    Rating createRating(Rating rating);

    // Get All Ratings
    List<Rating> getAllRatings();

    // Get Ratings By User Id
    List<Rating> getRatingsByUserId(String userId);

    // Get Ratings By Hotel Id
    List<Rating> getRatingsByHotelId(String hotelId);

    Rating getRatingById(String ratingId);

    Rating updateRating(String ratingId, Rating rating);

    void deleteRating(String ratingId);
}