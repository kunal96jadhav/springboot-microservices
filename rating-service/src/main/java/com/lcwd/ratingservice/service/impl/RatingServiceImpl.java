package com.lcwd.ratingservice.service.impl;

import com.lcwd.ratingservice.entity.Rating;
import com.lcwd.ratingservice.exception.ResourceNotFoundException;
import com.lcwd.ratingservice.repository.RatingRepository;
import com.lcwd.ratingservice.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating createRating(Rating rating) {

        rating.setRatingId(UUID.randomUUID().toString());

        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public Rating getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rating not found with id : " + ratingId));
    }

    @Override
    public Rating updateRating(String ratingId, Rating rating) {

        Rating existingRating = ratingRepository.findById(ratingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rating not found with id : " + ratingId));

        existingRating.setUserId(rating.getUserId());
        existingRating.setHotelId(rating.getHotelId());
        existingRating.setRating(rating.getRating());
        existingRating.setFeedback(rating.getFeedback());

        return ratingRepository.save(existingRating);
    }

    @Override
    public void deleteRating(String ratingId) {

        Rating existingRating = ratingRepository.findById(ratingId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Rating not found with id : " + ratingId));

        ratingRepository.delete(existingRating);
    }
}