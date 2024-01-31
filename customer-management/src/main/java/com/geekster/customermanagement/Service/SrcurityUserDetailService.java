package com.geekster.customermanagement.Service;

import com.geekster.customermanagement.Model.User;
import com.geekster.customermanagement.Repo.IUserRepo;
import com.geekster.customermanagement.mapper.UserToUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SrcurityUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user=userRepo.findByEmail(email);
        return user.map(UserToUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found with email "+email));
    }
}
