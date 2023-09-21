package com.icwd.rating.RatingService.impl;

import com.icwd.rating.RatingService.entities.Rating;
import com.icwd.rating.RatingService.repository.RatingRepository;
import com.icwd.rating.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository repository;

    @Override
    public Rating create(Rating rating) {
        return  repository.save(rating);

    }

    @Override
    public List<Rating> getRatings() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return repository.getRatingByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return repository.getRatingByHotelId(hotelId);
    }
}
