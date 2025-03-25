/**
 * The User class represents a model for user data with fields for id, name, and email.
 */
package learning.example.learn.Model;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The class `User` represents a user entity with properties such as id, name, and email, along with
 * constructors and getter/setter methods.
 */
@Document(collection = "users")
public class User {
    
    @Id
    private String id;
    
    private String name; 
    private String email;


    // This part of the code defines the `User` class in Java. Here's a breakdown of what each section
    // does:
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
