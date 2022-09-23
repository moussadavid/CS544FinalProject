package edu.mum.cs544.keycloak;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KeycloakAdminClientConfig {
    private String serverUrl;
    private String realm;
    private String clientId;
}
