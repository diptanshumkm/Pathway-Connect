package com.example.rdms.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rdms.Model.UserModel;
import com.example.rdms.Service.UserService;

@RestController
@RequestMapping("/students")
public class UserController {
    
    @Autowired
    private UserService userService;


    @PostMapping("/add-users")
    public UserModel addUser(@RequestBody UserModel user){
        return userService.addStudent(user);
    }    


    @GetMapping("/get-all-users")
    public List<UserModel> getAllStudent(){
        return userService.getAllStudent();
    }

    @GetMapping("/get-all-users/{id}")
    public Optional<UserModel> getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@RequestBody UserModel user, @PathVariable Long id){
        return userService.updateStudent(id, user);
    }

    @PatchMapping("/{id}")
    public UserModel updatePartialUser(@RequestBody UserModel user, @PathVariable Long id){
        return userService.updatePartialStudent(id, user);
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteStudentById(id);
        return "Student deleted Successfully!";
    }

}
