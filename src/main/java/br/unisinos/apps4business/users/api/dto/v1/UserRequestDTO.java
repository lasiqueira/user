package br.unisinos.apps4business.users.api.dto.v1;

import br.unisinos.apps4business.users.enumerators.Role;

import java.util.List;

public record UserRequestDTO(Role role, String login, String name, String email, List<UserGroupDTO> userGroups) {}
