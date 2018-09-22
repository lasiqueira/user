package br.unisinos.apps4business.users.api.dto.v1;

import br.unisinos.apps4business.users.enumerators.Role;

import java.util.List;

public class UserResponseDTO {

    private Long id;
    private Role role;
    private String login;
    private String name;
    private String email;
    private List<UserGroupDTO> userGroups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserGroupDTO> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroupDTO> userGroups) {
        this.userGroups = userGroups;
    }
}