package com.project.service;

import com.project.model.Session;
import com.project.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    public static String username;
    public static int userId;

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //Logic to get the user form the Database
        Session principal= sessionRepository.findByUserName(userName);

        if (principal==null) throw new UsernameNotFoundException("Invalid Username");

        username= principal.getUserName();
        String password= principal.getPassword();
        userId= principal.getSessionId();
        return new User(username,password,new ArrayList<>());
    }

}
