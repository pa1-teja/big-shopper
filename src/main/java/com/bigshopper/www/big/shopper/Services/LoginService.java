package com.bigshopper.www.big.shopper.Services;

import com.bigshopper.www.big.shopper.Entities.LoginTable;
import com.bigshopper.www.big.shopper.JPARepositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginTable user = loginRepository.findUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), new ArrayList<>());
    }
}
