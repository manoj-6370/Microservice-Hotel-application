package com.icwd.user.service.impl;

import com.icwd.user.service.entities.Hotel;
import com.icwd.user.service.entities.Rating;
import com.icwd.user.service.entities.User;
import com.icwd.user.service.exceptions.ResourceNotFoundException;
import com.icwd.user.service.externalservice.HotelService;
import com.icwd.user.service.repositories.UserRepository;
import com.icwd.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   private RestTemplate restTemplate;
@Autowired
   private HotelService hotelService;
   private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user) ;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user= userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found on server !! :"+userId));
//url=http://localhost:8084/users/bda6a34b-ee69-4f64-bac9-4f1326632828
        Rating [] userRatings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating [].class);
        logger.info("{}",userRatings);
        List<Rating> listRating= Arrays.stream(userRatings).toList();
        List<Rating> ratings=listRating.stream().map(rating -> {
            //url=http://localhost:8080/hotel/0c0b907e-013d-4a31-a05c-2f884de08621
          //  ResponseEntity<Hotel> respRating=restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);

             Hotel hotel=hotelService.getHotel(rating.getHotelId());
          // Hotel hotel=respRating.getBody();
          //  logger.info("response status code : {}",respRating.getStatusCode());

            rating.setHotel(hotel);
            return rating;

        }).collect(Collectors.toList());

         user.setRating(ratings);
        return user;

    }
}
