package ru.davtyan.sequrity.spring_sequrity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.davtyan.sequrity.spring_sequrity.entityes.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    boolean existsByName(String name);

    boolean existsByEmail(String name);

}
