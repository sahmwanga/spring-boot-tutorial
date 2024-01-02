package com.sahmwanga.demo.service.auth;

import com.sahmwanga.demo.entity.User;
import com.sahmwanga.demo.entity.VerificationToken;
import com.sahmwanga.demo.model.UserModel;
import org.springframework.stereotype.Service;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);
}
