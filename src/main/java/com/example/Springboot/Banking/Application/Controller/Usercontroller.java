package com.example.Springboot.Banking.Application.Controller;

import com.example.Springboot.Banking.Application.Model.User;
import com.example.Springboot.Banking.Application.Services.Userservices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private Userservices userservices;

    @PostMapping("/AddUser")
    private User adddata(@RequestBody @Valid User u){
        return userservices.adddata(u);
    }

    @GetMapping("/GetAll")
    private List<User> getall(){
        return userservices.getall();
    }

    @GetMapping("/gbyid/{id}")
    private Optional<User> getbyid (@PathVariable Long id){
        return userservices.gbyid(id);
    }

    @GetMapping("/gbyname")
    private User gbyname(@RequestParam String name){
        return userservices.gbyname(name);
    }
}
