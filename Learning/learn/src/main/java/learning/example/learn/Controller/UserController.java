package learning.example.learn.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import learning.example.learn.Service.UserService;
import learning.example.learn.LearnApplication;
import learning.example.learn.Model.User;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;
 
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "User with ID " + id + " deleted successfully";
    }


    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable String id){
        return userService.updateUser(id, user);
    }

    @PatchMapping("/{id}")
    public User patchUserUpdate(@RequestBody User user, @PathVariable String id){
        return userService.patchUserUpdate(id, user);
    }


}
