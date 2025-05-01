package rw.vladvisionlab.inzozi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rw.vladvisionlab.inzozi.dtos.DeleteUserRequest;
import rw.vladvisionlab.inzozi.dtos.UserDto;
import rw.vladvisionlab.inzozi.models.AppUser;
import rw.vladvisionlab.inzozi.repositories.AppUserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserDto> getAllUsers(){
        return userRepository.findAll()
            .stream()
            .map(user ->new UserDto(user.getFirstname(), user.getLastname(), user.getEmail()))
            .collect(Collectors.toList());
    }

    // Delete user by email and password
    public void deleteUser(DeleteUserRequest request) {
    AppUser user = userRepository.findByEmail(request.getEmail())
        .orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        throw new RuntimeException("Invalid credentials");
    }

    userRepository.delete(user);
}

}
