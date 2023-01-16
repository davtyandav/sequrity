package ru.davtyan.sequrity.spring_sequrity.dto.registracion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto implements Serializable {

    private String name;
    private String email;
    private String password;
    private List<RoleDto> roles = new ArrayList<>();

}
