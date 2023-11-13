package com.example.marketplace.service;

import com.example.marketplace.dto.UserDtos.UserDto;
import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.UserDtos.UserNewDto;
import com.example.marketplace.entity.User;

import java.util.List;

public interface IUserServices {

    SuccessDto registerUser(UserNewDto userNewDto);

    SuccessDto authenticateUser(String username, String password);

    SuccessDto updateUserProfile(UserDto userDto);

    UserDto getUserById(String userId);

    User getUserByEmail(String email);

    List<UserDto> getAllUsers();

    SuccessDto deleteUserById(String userId);
}
