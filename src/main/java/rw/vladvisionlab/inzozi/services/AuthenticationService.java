package rw.vladvisionlab.inzozi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rw.vladvisionlab.inzozi.dtos.AuthenticationRequest;
import rw.vladvisionlab.inzozi.dtos.AuthenticationResponse;
import rw.vladvisionlab.inzozi.dtos.RegisterRequest;
import rw.vladvisionlab.inzozi.models.AppUser;
import rw.vladvisionlab.inzozi.repositories.AppUserRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final AppUserRepository appUserRepository;


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // If authentication is successful, generate the JWT
        AppUser user = (AppUser) authentication.getPrincipal();
        String token = jwtService.generateToken(user.getUsername());

        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    public AuthenticationResponse register(RegisterRequest request){
        // Map RegisterRequest to AppUser model
        AppUser newUser = AppUser.builder()
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .build();
        
        // Save the new user to the database
        appUserRepository.save(newUser);

         // Optionally, generate a JWT token for the newly registered user
         String token = jwtService.generateToken(newUser.getEmail());

         // Return a response with the token
        return AuthenticationResponse.builder().token(token).build();
    }
}
