package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.UserDtos.UserDto;
import com.example.marketplace.dto.UserDtos.UserNewDto;
import com.example.marketplace.service.IUserServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserServices {
    @Override
    public SuccessDto registerUser(UserNewDto userNewDto) {
        return null;
    }

    @Override
    public SuccessDto authenticateUser(String username, String password) {
        return null;
    }

    @Override
    public SuccessDto updateUserProfile(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto getUserById(String userId) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public SuccessDto deleteUserById(String userId) {
        return null;
    }
}
