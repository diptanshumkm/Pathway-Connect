package learning.example.learn.Model;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    
    @Id
    private String id;
    private String name; 
    private String email;


    public User(){}

    public User(String name, String email){
        this.name =name;
        this.email = email;
    }

    // Getters and setters
    public String getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setEmail(String email){
        this.email =email;
    }
    public String getEmail(){
        return email;
    }
    

}
