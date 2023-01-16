package ru.davtyan.sequrity.spring_sequrity.entityes;

import lombok.Getter;

@Getter
public enum ERole {
    USER("user"),ADMIN("admin"),MODERATOR("moderator");

    private final String name;

    ERole(String name){
        this.name = name;
    }
}
