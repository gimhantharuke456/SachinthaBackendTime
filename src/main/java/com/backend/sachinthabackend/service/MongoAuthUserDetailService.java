package com.backend.sachinthabackend.service;

import com.backend.sachinthabackend.model.User;
import com.backend.sachinthabackend.repositary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MongoAuthUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    MongoAuthUserDetailService (UserRepository repository){
        this.userRepository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userRepository.findUserByUsername(userName);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        user.getAuthorities()
                .forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(
                        role.getAuthority()
                )));

        return new User(user.getUsername(), user.getPassword(),user.getRole(),user.getEmail());
    }

}