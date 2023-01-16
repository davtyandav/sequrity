package ru.davtyan.sequrity.spring_sequrity.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String name, String password);
}
