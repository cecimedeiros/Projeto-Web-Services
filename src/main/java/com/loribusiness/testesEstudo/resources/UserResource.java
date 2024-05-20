package com.loribusiness.testesEstudo.resources;

import com.loribusiness.testesEstudo.entities.User;
import com.loribusiness.testesEstudo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping //retorna todos users
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //retorna um user com base no id. graças a isso aqui aquele users/1 é possível
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
//esses novos métodos são para que seja possivel inserir um novo objeto pelo Postman
/*
- no postman troque o método get por post
- no caminho "http://localhost:8080/users"
- vá na aba body (abaixo do caminho)
- sub-aba raw
- cola isso aqui:
{
    "name": "Lori",
    "email": "lori@leromail.com",
    "phone": "991862052",
    "password": "000000"
}
- veja se o JSON realmente está selecionado
- se no status tiver um 200 OK é sinal de que deu bom, pode comemorar
*/