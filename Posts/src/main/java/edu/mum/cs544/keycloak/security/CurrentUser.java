package edu.mum.cs544.keycloak.security;

import java.util.List;

import lombok.Data;

@Data
public class CurrentUser {

    private String userId;
    private String username;
    private String email;
    private List<String> roles;
}
