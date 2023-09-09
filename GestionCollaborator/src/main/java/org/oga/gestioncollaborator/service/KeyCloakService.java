package org.oga.gestioncollaborator.service;

import io.phasetwo.client.OrganizationResource;
import io.phasetwo.client.OrganizationRolesResource;
import io.phasetwo.client.OrganizationsResource;
import io.phasetwo.client.PhaseTwo;
import io.phasetwo.client.openapi.model.OrganizationRepresentation;
import io.phasetwo.client.openapi.model.OrganizationRoleRepresentation;
import org.keycloak.admin.client.Keycloak;
import org.oga.gestioncollaborator.Entity.OrgDTO;
import org.oga.gestioncollaborator.config.KeycklockConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class KeyCloakService  {
    @Autowired
    KeycklockConfig keycklockConfig;
    public String addOrg(OrgDTO orgDTO) {
        Keycloak keycloak = keycklockConfig.getInstance();
        PhaseTwo phaseTwo = new PhaseTwo(keycloak, keycklockConfig.getSERVER_URL());

        OrganizationRepresentation organizationRepresentation = new OrganizationRepresentation().name(orgDTO.getName());


        OrganizationsResource orgs = phaseTwo.organizations(keycklockConfig.getREALM());

        String orgId = orgs.create(organizationRepresentation);

        return orgId;
    }




    public List<OrganizationRepresentation >getOrg() {
        Keycloak keycloak = keycklockConfig.getInstance();
        PhaseTwo phaseTwo = new PhaseTwo(keycloak, keycklockConfig.getSERVER_URL());

        List<OrganizationRepresentation> organizations = phaseTwo.organizations(keycklockConfig.REALM).get();

        return  organizations;
    }


    public String addRole(String roleName){
        Keycloak keycloak = keycklockConfig.getInstance();
        PhaseTwo phaseTwo = new PhaseTwo(keycloak, keycklockConfig.getSERVER_URL());
        String organizationId = "0b5c4891-bf32-4cf2-abb6-51c3892cc8ad";

        OrganizationsResource orgsResource = phaseTwo.organizations(keycklockConfig.getREALM());

        // Attribuer le rôle à l'utilisateur
        OrganizationResource orgResource = orgsResource.organization(organizationId);

        OrganizationRolesResource rolesResource = orgResource.roles();

        String name = rolesResource.create(new OrganizationRoleRepresentation().name(roleName));
        return name;
    }
    public List<String> getAllRoles(String orgId) {
        Keycloak keycloak = keycklockConfig.getInstance();
        PhaseTwo phaseTwo = new PhaseTwo(keycloak, keycklockConfig.getSERVER_URL());
        OrganizationsResource orgsResource = phaseTwo.organizations(keycklockConfig.getREALM());
        OrganizationResource orgResource = orgsResource.organization(orgId);
        OrganizationRolesResource rolesResource = orgResource.roles();
        List<String> roles = new ArrayList<>();
        List<OrganizationRoleRepresentation> roleList = rolesResource.get();
        for (OrganizationRoleRepresentation role : roleList) {
            roles.add(role.getName());
        }
        return roles;
    }




}
