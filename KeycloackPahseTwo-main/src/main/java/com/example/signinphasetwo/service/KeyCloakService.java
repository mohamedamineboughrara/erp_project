package com.example.signinphasetwo.service;

import com.example.signinphasetwo.Entity.OrgEntity;
import com.example.signinphasetwo.config.KeycklockConfig;
import io.phasetwo.client.OrganizationsResource;
import io.phasetwo.client.PhaseTwo;
import io.phasetwo.client.openapi.model.OrganizationRepresentation;
import org.keycloak.admin.client.Keycloak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KeyCloakService  {
@Autowired
KeycklockConfig keycklockConfig;
    public String addOrg(OrgEntity orgEntity) {
        Keycloak keycloak = keycklockConfig.getInstance();
        PhaseTwo phaseTwo = new PhaseTwo(keycloak, keycklockConfig.getSERVER_URL());

        OrganizationRepresentation organizationRepresentation = new OrganizationRepresentation().name(orgEntity.getName());


        OrganizationsResource orgs = phaseTwo.organizations(keycklockConfig.getREALM());

        String orgId = orgs.create(organizationRepresentation);

        return orgId;
    }
    public List<OrganizationRepresentation >gettOrg() {
        Keycloak keycloak = keycklockConfig.getInstance();
        PhaseTwo phaseTwo = new PhaseTwo(keycloak, keycklockConfig.getSERVER_URL());

        List<OrganizationRepresentation> organizations = phaseTwo.organizations(keycklockConfig.REALM).get();

        return  organizations;
    }



}
