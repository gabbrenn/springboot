package rw.vladvisionlab.inzozi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rw.vladvisionlab.inzozi.dtos.AuthenticationRequest;
import rw.vladvisionlab.inzozi.dtos.AuthenticationResponse;
import rw.vladvisionlab.inzozi.dtos.RegisterRequest;
import rw.vladvisionlab.inzozi.services.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public AuthenticationResponse register(
            @RequestBody RegisterRequest request
    ) {
        return authenticationService.register(request);
    }

    @PostMapping("/login")  // Updated endpoint to match security config
    public AuthenticationResponse authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return authenticationService.authenticate(request);
    }
}
