package com.example.marketplace.controller;

import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.UserDtos.UserDto;
import com.example.marketplace.dto.UserDtos.UserNewDto;
import com.example.marketplace.service.IUserServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/users")
@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final IUserServices userService;

    @PostMapping("/register")
    @ApiOperation(value = "Register user")
    public ResponseEntity<SuccessDto> registerUser(@RequestBody UserNewDto userNewDto) {
        return ResponseEntity.ok(userService.registerUser(userNewDto));
    }

    @PostMapping("/authenticate")
    @ApiOperation(value = "Authenticate user")
    public ResponseEntity<SuccessDto> authenticateUser(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.ok(userService.authenticateUser(username, password));
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update user profile")
    public ResponseEntity<SuccessDto> updateUserProfile(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUserProfile(userDto));
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "Get user by ID")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId) {
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/email/{email}")
    @ApiOperation(value = "Get user by email")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        UserDto userDto = userService.getUserByEmail(email);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/delete/{userId}")
    @ApiOperation(value = "Delete user by ID")
    public ResponseEntity<SuccessDto> deleteUserById(@PathVariable String userId) {
        return ResponseEntity.ok(userService.deleteUserById(userId));
    }
}
