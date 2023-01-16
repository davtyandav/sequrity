package ru.davtyan.sequrity.spring_sequrity.service.role;

import ru.davtyan.sequrity.spring_sequrity.entityes.Role;

public interface RoleService {

    Role findByName(String name);
}
