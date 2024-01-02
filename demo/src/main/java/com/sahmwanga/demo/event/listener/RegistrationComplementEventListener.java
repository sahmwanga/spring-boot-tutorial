package com.sahmwanga.demo.event.listener;

import com.sahmwanga.demo.entity.User;
import com.sahmwanga.demo.event.RegistrationCompleteEvent;
import com.sahmwanga.demo.service.auth.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationComplementEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;


    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // create the verification token for the user;


        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);

        // send Mail to user;
        String url = event.getApplicationUrl() + "/verifyRegistration?token="+token;

        //sendVerificationEmail()
        log.info("Click the link to verify your account: {}", url);
    }
}
