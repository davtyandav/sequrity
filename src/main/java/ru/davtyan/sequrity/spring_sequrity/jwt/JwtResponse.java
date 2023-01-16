package ru.davtyan.sequrity.spring_sequrity.jwt;

import lombok.Getter;
import lombok.Setter;
import ru.davtyan.sequrity.spring_sequrity.entityes.Role;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String userName;
    private String email;
    private Set<Role> roles = new HashSet<>();

}


