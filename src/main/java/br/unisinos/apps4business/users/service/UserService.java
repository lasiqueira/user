package br.unisinos.apps4business.users.service;

import br.unisinos.apps4business.users.enumerators.Role;
import br.unisinos.apps4business.users.model.User;
import br.unisinos.apps4business.users.model.UserGroup;
import br.unisinos.apps4business.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> fetchAllUsers(){
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(user -> list.add(user));
        return list;
    }

    public List<User> findByUserGroup(UserGroup userGroup) {
        return userRepository.findByUserGroup(userGroup);
    }

    public List<User> findByRole(Role role){
        return userRepository.findByRole(role);
    }
    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }
    public User saveUser(User user){
       return userRepository.save(user);
    }
    public User saveUser(Long id, User user){
        if(userRepository.existsById(id)){
            user.setId(id);
            return userRepository.save(user);
        } else{
            throw new NotFoundException();
        }
    }

    public void deleteUser(Long id){
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else{
            throw new NotFoundException();
        }
    }
}