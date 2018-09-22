package br.unisinos.apps4business.users.api.converter.v1;

import br.unisinos.apps4business.users.api.dto.v1.UserGroupRequestDTO;
import br.unisinos.apps4business.users.api.dto.v1.UserGroupResponseDTO;
import br.unisinos.apps4business.users.model.UserGroup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserGroupConverterTest {

    @Autowired
    private UserGroupConverter userGroupConverter;
    private UserGroup userGroup;
    private UserGroupResponseDTO userGroupResponseDTO;
    private UserGroupRequestDTO userGroupRequestDTO;
    private List<UserGroup> userGroups;

    @Before
    public void setup(){
        userGroup = random(UserGroup.class);
        userGroupRequestDTO = random(UserGroupRequestDTO.class);
        userGroupResponseDTO = random(UserGroupResponseDTO.class);
        userGroups = new ArrayList<>();
        userGroups.add(userGroup);
    }

    @Test
    public void convertRequestToEntityTest(){
        UserGroup entity = userGroupConverter.convertRequestToEntity(userGroupRequestDTO);
        assertNotNull(entity);
        assertEquals(entity.getDescription(), userGroupRequestDTO.getDescription());
        assertEquals(entity.getName(), userGroupRequestDTO.getName());
    }
    @Test
    public void convertEntityListToResponseListTest(){
        List<UserGroupResponseDTO> responseList = userGroupConverter.convertEntityListToResponseList(userGroups);
        assertNotNull(responseList);
        assertFalse(responseList.isEmpty());
    }
    @Test
    public void convertEntityToResponseTest(){
        UserGroupResponseDTO response = userGroupConverter.convertEntityToResponse(userGroup);
        assertNotNull(response);
        assertEquals(response.getId(), userGroup.getId());
        assertEquals(response.getDescription(), userGroup.getDescription());
        assertEquals(response.getName(), userGroup.getName());
    }
}