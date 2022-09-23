package edu.mum.cs544.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.core.Response;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs544.dtos.KCCreateUser;
import edu.mum.cs544.keycloak.KeycloakAdminClientConfig;
import edu.mum.cs544.keycloak.KeycloakAdminClientUtils;
import edu.mum.cs544.keycloak.KeycloakPropertyReader;

@Service
public class KeycloakAdminClientService {
    @Autowired
    private KeycloakPropertyReader keycloakPropertyReader;

    public KCCreateUser createNewUser(String username, String password) {
        UsersResource usersResource = getRealmResource().users();

        UserRepresentation user = new UserRepresentation();
        user.setUsername(username);
        user.setEnabled(true);

        CredentialRepresentation cred = new CredentialRepresentation();
        cred.setValue(password);
        user.setCredentials(Collections.singletonList(cred));

        Response result = usersResource.create(user);
        KCCreateUser returnResult = new KCCreateUser(result.getStatus(), null);
        if (result.getStatus() == 201) {
            List<UserRepresentation> users = usersResource.search(username);
            returnResult.setKCId(users.get(0).getId());
        }
        return returnResult;
    }

    private RealmResource getRealmResource() {
        KeycloakAdminClientConfig keycloakAdminClientConfig = KeycloakAdminClientUtils
                .loadConfig(keycloakPropertyReader);
        Keycloak keycloak = KeycloakAdminClientUtils.getKeycloakClient(keycloakAdminClientConfig);

        // Get realm
        return keycloak.realm(keycloakAdminClientConfig.getRealm());
    }
}
