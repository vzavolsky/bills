package bill.app.controllers;

import bill.app.entities.User;
import bill.app.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User index() {
        return userService.getUserById(1L);
    }

    @PostMapping
    public User authUser(@RequestBody User user) {
        return userService.save(user);
    }
}
