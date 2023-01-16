package ru.davtyan.sequrity.spring_sequrity.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.davtyan.sequrity.spring_sequrity.entityes.Role;
import ru.davtyan.sequrity.spring_sequrity.entityes.User;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User user = userServiceImpl.fainByName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("user not fount :" + userName);
        }

        Set<GrantedAuthority> roles = new HashSet<>();

        for (Role role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getName().toString()));
        }

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), roles);
    }

    public String getUserName() {
        return "null";
    }
}
