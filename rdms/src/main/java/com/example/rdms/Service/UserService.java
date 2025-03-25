package com.example.rdms.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rdms.Model.UserModel;
import com.example.rdms.Repository.UserRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;


    public UserModel addStudent(UserModel user){
        return userRepo.save(user);
    }

    public List<UserModel> getAllStudent(){
        return userRepo.findAll();
    }


    public Optional<UserModel> getById(Long id){
        return userRepo.findById(id);
    }

    // PUT Business Logic
    public UserModel updateStudent(Long id, UserModel newUser){
        Optional<UserModel> optionalData = userRepo.findById(id);
        if (optionalData.isPresent()) {
            UserModel data = optionalData.get();
            data.setName(newUser.getName());
            data.setEmail(newUser.getEmail());
            data.setAge(newUser.getAge());
            return userRepo.save(data);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    
    // Patch Method
    public UserModel updatePartialStudent(Long id, UserModel newUser){

        Optional<UserModel> OptionalData = userRepo.findById(id);

        if (OptionalData.isPresent()) {

            UserModel data = OptionalData.get();
            if (newUser.getEmail() != null) {
                data.setEmail(newUser.getEmail());
            }
            if (newUser.getName() != null) {
                data.setName(newUser.getName());
            }
            if (newUser.getAge() !=null) {
                data.setAge(newUser.getAge());
            }

            return userRepo.save(data);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

    }



    // Delete Logic
    public String deleteStudentById(Long id){
        Optional<UserModel> optionalData = userRepo.findById(id);
        if (optionalData.isPresent()) {
            UserModel data = optionalData.get();
            userRepo.delete(data);
            return "Student deleted successfully!";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }


}
