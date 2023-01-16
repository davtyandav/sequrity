package ru.davtyan.sequrity.spring_sequrity.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.davtyan.sequrity.spring_sequrity.dto.registracion.RoleDto;
import ru.davtyan.sequrity.spring_sequrity.dto.registracion.UserDto;
import ru.davtyan.sequrity.spring_sequrity.entityes.Role;
import ru.davtyan.sequrity.spring_sequrity.entityes.User;
import ru.davtyan.sequrity.spring_sequrity.service.role.RoleService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserHelper {


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleService roleService;

    public User convertUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        List<Role> collect = userDto.getRoles().stream().map(this::convertRole).collect(Collectors.toList());
        user.setRoles(collect);
        return user;
    }

    private Role convertRole(RoleDto roleDto) {
        return roleService.findByName(roleDto.getName());
    }

}
