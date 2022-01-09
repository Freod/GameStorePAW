package pl.umg.paw.gamestorepaw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.umg.paw.gamestorepaw.security.MyUserDetails;
import pl.umg.paw.gamestorepaw.model.User;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserServiceImpl service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = service.findByEmail(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found:" + username));

        return user.map(MyUserDetails::new).get();
    }
}
