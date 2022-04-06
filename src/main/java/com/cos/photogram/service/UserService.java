package com.cos.photogram.service;

import com.cos.photogram.domain.user.User;
import com.cos.photogram.domain.user.UserRepository;
import com.cos.photogram.handler.ex.CustomException;
import com.cos.photogram.handler.ex.CustomValidationApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User userProfile(int userId) {
        User userEntity = userRepository.findById(userId).orElseThrow(() -> {
            throw new CustomException("Profile page doesn't exist");
        });
        return userEntity
    }

    @Transactional
    public User editUser(int id, User user) {
        // 1. Persistence
        User userEntity = userRepository.findById(id).orElseThrow(() -> {
            return new CustomValidationApiException("Cannot find your id");
        });

        // 2. Edit object - Dirty checking(update finished)
        userEntity.setName(user.getName());

        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        userEntity.setPassword(encPassword);

        userEntity.setBio(user.getBio());
        userEntity.setWebsite(user.getWebsite());
        userEntity.setPhone(user.getPhone());
        userEntity.setGender(user.getGender());

        return userEntity;
    }

}
