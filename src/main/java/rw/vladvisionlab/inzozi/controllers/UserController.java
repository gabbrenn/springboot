package rw.vladvisionlab.inzozi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rw.vladvisionlab.inzozi.dtos.DeleteUserRequest;
import rw.vladvisionlab.inzozi.dtos.UserDto;
import rw.vladvisionlab.inzozi.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // GET all users (without password)
    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // DELETE user by email and password
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody DeleteUserRequest request) {
        userService.deleteUser(request);
        return ResponseEntity.ok("User successfully deleted");
    }

}
