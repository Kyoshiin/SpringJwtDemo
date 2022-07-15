package com.roy.springjwt.services;

import com.roy.springjwt.models.UserModel;
import com.roy.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Roy on 14-07-2022
 */

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /* fetching user by userName, if user is null the throw exception, otherwise
         * return user
         */
        UserModel userModel = userRepository.findByUserName(username);
        if (userModel == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(userModel.getUserName(), userModel.getPassword(), new ArrayList<>());

        /*
        or create a class extending UserDetails and return it
        return new MyUserDeails(userModel);
         */
    }
}
