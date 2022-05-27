package com.example.demo.Registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {
    private RegistrationService registrationService;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        System.out.println("YES\n");
        return registrationService.register(request);
    }
}
