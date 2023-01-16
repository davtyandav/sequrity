package ru.davtyan.sequrity.spring_sequrity.service.user;


import ru.davtyan.sequrity.spring_sequrity.dto.registracion.UserDto;
import ru.davtyan.sequrity.spring_sequrity.entityes.User;

public interface UserService {

    UserDto auth(UserDto user);

    User fainByName(String name);

    User registration(UserDto user);
}
