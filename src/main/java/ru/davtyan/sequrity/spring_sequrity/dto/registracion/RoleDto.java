package ru.davtyan.sequrity.spring_sequrity.dto.registracion;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RoleDto implements Serializable {
    private String name;
}
