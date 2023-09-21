package com.icwd.user.service.services;


import com.icwd.user.service.entities.User;

import java.util.List;

public interface UserService {
User saveUser(User user);

List<User> getAllUser();

User getUser(String UserId);


}
