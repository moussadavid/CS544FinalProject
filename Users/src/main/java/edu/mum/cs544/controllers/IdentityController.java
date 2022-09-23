package edu.mum.cs544.controllers;

import lombok.var;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/identity")
@CrossOrigin
public class IdentityController {
    @GetMapping()
    public void getUserInfo() {
        KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken) SecurityContextHolder.getContext()
                .getAuthentication();

        final Principal principal = (Principal) authentication.getPrincipal();

        String userIdByToken = "";
        String userIdByMapper = "";

        if (principal instanceof KeycloakPrincipal) {
            KeycloakPrincipal<KeycloakSecurityContext> kPrincipal = (KeycloakPrincipal<KeycloakSecurityContext>) principal;
            var token = kPrincipal.getKeycloakSecurityContext().getIdToken();

            userIdByToken = token.getSubject();
            userIdByMapper = token.getOtherClaims().get("sid").toString();
        }
    }
}
