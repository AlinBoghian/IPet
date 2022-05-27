package com.example.demo.Registration;

import com.example.demo.Registration.token.ConfirmationToken;
import com.example.demo.Registration.token.ConfirmationTokenService;
import com.example.demo.controller.UserController;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {
    private EmailValidator emailValidator;
    private UserController controller;
    private ConfirmationTokenService confirmationTokenService;
    public String register(RegistrationRequest request) {
        boolean valid = emailValidator.test(request.getEmail());
        if(!valid) {
            throw new IllegalStateException("Email not valid");
        }
        return controller.signUp(
                new User(
                        request.getUsername(),
                        request.getPassword(),
                        request.getEmail(),
                        UserRole.USER
                )
        );
    }
//    @Transactional
//    public String confirmToken(String token) {
//        ConfirmationToken confirmationToken = confirmationTokenService
//                .getToken(token)
//                .orElseThrow(() ->
//                        new IllegalStateException("token not found"));
//
//        if (confirmationToken.getConfirmedAt() != null) {
//            throw new IllegalStateException("email already confirmed");
//        }
//
//        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
//
//        if (expiredAt.isBefore(LocalDateTime.now())) {
//            throw new IllegalStateException("token expired");
//        }
//
//        confirmationTokenService.setConfirmedAt(token);
//        controller.enableUser(
//                confirmationToken.getUser().getEmail());
//        return "confirmed";
//    }


}
