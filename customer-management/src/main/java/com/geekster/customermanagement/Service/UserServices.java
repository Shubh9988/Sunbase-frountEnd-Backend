package com.geekster.customermanagement.Service;


import com.geekster.customermanagement.Model.User;
import com.geekster.customermanagement.Repo.IUserRepo;
import com.geekster.customermanagement.dto.UserDto;
import com.geekster.customermanagement.mapper.Usermapper;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UserServices {
    @Autowired
    private IUserRepo userRepo;

    public UserServices() {
    }

    @Autowired
    private PasswordEncoder encoder;
    public void registerUser(UserDto userDto) {
        User user= Usermapper.UserDtoToUser(userDto, new User());
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
    }


}