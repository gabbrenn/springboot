package rw.vladvisionlab.inzozi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        authenticationService.register(request);
        return ResponseEntity.ok("User registered successfully");
    }
    

    @PostMapping("/login")  // Updated endpoint to match security config
    public AuthenticationResponse authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return authenticationService.authenticate(request);
    }
}
