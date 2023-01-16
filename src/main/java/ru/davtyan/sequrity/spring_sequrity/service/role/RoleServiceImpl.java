package ru.davtyan.sequrity.spring_sequrity.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.davtyan.sequrity.spring_sequrity.dao.RoleRepository;
import ru.davtyan.sequrity.spring_sequrity.entityes.Role;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name).get();
    }
}
