package com.lucaffo.dinotodo.services;

import com.lucaffo.dinotodo.models.User;
import com.lucaffo.dinotodo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository users;

    @Autowired
    public UserService (UserRepository userRepository)
    {
        this.users = userRepository;
    }

    public List<User> getAllUsers(){
        return users.findAll();
    }

    public User getUserById(Long id){
        return users.findById(id).orElseThrow();
    }

    public User createUser(User user){
        return users.save(user);
    }

    public User updateUser(Long id, User user){
        User fetchUser = users.findById(id).orElseThrow();
        fetchUser.setName(user.getName());
        fetchUser.setEmail(user.getEmail());
        return users.save(fetchUser);
    }

    public void deleteUser(Long id){
        User fetchUser = users.findById(id).orElseThrow();
        users.delete(fetchUser);
    }
}