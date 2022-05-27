package com.example.demo.Registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.Configuration;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private ConfirmationTokenRepository repo;

    public  void saveConfirmationToken(ConfirmationToken token) {
        repo.save(token);
    }
}
