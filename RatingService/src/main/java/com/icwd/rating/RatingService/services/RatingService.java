package com.icwd.rating.RatingService.services;

import com.icwd.rating.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {
    Rating create(Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
