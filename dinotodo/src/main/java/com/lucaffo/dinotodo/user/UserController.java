package com.lucaffo.dinotodo.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.getReferenceById(id);
    }

    @PostMapping
    public User createNewUser(@RequestBody User user){
        return userRepository.save(user);
    }

    // Modify an existing user by ID
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        User fetchUser = userRepository.findById(id).get();
        fetchUser.setName(user.getName());
        fetchUser.setEmail(user.getEmail());
        return userRepository.save(fetchUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        try{
            userRepository.deleteById(id);
            return "Deleted user";
        }catch(Exception e){
            return "User not found";
        }
    }
}