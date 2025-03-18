package learning.example.learn.Service;

import learning.example.learn.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import learning.example.learn.Repository.UserRepository;


@Service
public class UserService {

    
    @Autowired
    private UserRepository userRepository;




    public List<User> getAllUser(){
        return userRepository.findAll();
    }


    public User addUser(User user){
        return userRepository.save(user);
    }


    public String deleteUser(String id){
        userRepository.deleteById(id);
        return "User deleted Successfully";
    }    

    // PUT request handler
    public User updateUser(String id, User newUser){

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User data = optionalUser.get();

            if (newUser.getName() != null) {
                data.setName(newUser.getName());
            }

            if (newUser.getEmail() !=null) {
                data.setEmail(newUser.getEmail()); 
            }

            return userRepository.save(data);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }


}
