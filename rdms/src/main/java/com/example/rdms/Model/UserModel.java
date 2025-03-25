package com.example.rdms.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "students")
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment primary key
    private Long id;

    private String name;
    private String email;
    private Integer age;


    public UserModel(){}; 
    public UserModel(String name, String email, int age){
        this.email = email;
        this.name = name;
        this.age = age;
    }

    public Long getId(){ return this.id;}
    public void setId(Long id){this.id = id;}

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public Integer getAge(){
        return age;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public void setAge(Integer age){
        this.age = age;
    }


}
