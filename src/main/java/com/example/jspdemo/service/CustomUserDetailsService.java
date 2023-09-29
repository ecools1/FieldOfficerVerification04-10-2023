package com.example.jspdemo.service;

import com.example.jspdemo.model.PbfVvsUser;
import com.example.jspdemo.model.Verification;
import com.example.jspdemo.repo.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUser userRepo;
    static public int userId;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PbfVvsUser user = userRepo.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));


        userId = user.getId();


        if (user == null) {
            System.out.println("user1 is null");
        } else {
            System.out.println("user  is  " + userId);
        }



        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), new ArrayList<>());

    }

    public int CurrentUserId(){
        System.out.println( "inside CurrentUserId method " + userId);
        return userId;
    }

}
