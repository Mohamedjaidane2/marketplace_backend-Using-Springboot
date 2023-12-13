package com.example.marketplace.service.Impl;

import com.example.marketplace.dto.SuccessDtos.SuccessDto;
import com.example.marketplace.dto.UserDtos.UserDto;
import com.example.marketplace.dto.UserDtos.UserNewDto;
import com.example.marketplace.entity.*;
import com.example.marketplace.exception.EntityNotFoundException;
import com.example.marketplace.exception.ErrorCodes;
import com.example.marketplace.exception.InvalidOperationException;
import com.example.marketplace.repository.IAccountRepository;
import com.example.marketplace.repository.IHistoryRepository;
import com.example.marketplace.repository.IUserRepository;
import com.example.marketplace.service.IUserServices;
import com.example.marketplace.utils.SuccessMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements IUserServices , UserDetailsService {

    private final IUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final IAccountRepository iAccountRepository;
    private final IHistoryRepository iHistoryRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        if (user == null){
            throw new EntityNotFoundException("User not found", ErrorCodes.USER_NOT_FOUND);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }
    @Override
    public SuccessDto registerUser(UserNewDto userNewDto) {
        User user = repository.findByEmail(userNewDto.getEmail());

        if (user != null) {
            throw new InvalidOperationException("User already exist with this email", ErrorCodes.USER_ALREADY_IN_USE);
        }


            Account account = Account.builder()
                    .ownerEmail(userNewDto.getEmail())
                    .build();
            iAccountRepository.save(account);

        iAccountRepository.save(account);


        User newUser = Consumer.builder()
                .account(iAccountRepository.findByOwnerEmail(userNewDto.getEmail()))
                .email(userNewDto.getEmail())
                .password(passwordEncoder.encode(userNewDto.getPassword()))
                .build();


        repository.save(newUser);
        return SuccessDto.builder()
                .message(SuccessMessage.SUCCESSFULLY_CREATED)
                .build();
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
    public User getUserByEmail(String email) {
        User user = repository.findByEmail(email);

        if (user == null) {
            throw new EntityNotFoundException("User Not Found !", ErrorCodes.USER_NOT_FOUND);
        }
        return user;
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
