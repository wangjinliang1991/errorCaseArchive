package org.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("wrong")
    public User wrong(@RequestBody User user) {
        user.setName(String.format("guest%s", user.getName()));
        return userRepository.save(user);
    }

    @PostMapping("save")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
