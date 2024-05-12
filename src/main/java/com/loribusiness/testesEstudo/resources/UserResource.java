package com.loribusiness.testesEstudo.resources;

import com.loribusiness.testesEstudo.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Lori", "lori@leromail.com", "90906060", "159753");
        return ResponseEntity.ok().body(u);
    }

}
