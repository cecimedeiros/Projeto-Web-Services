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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ //void pois não tem resposta para uma deleção
        service.delete(id);
        return ResponseEntity.noContent().build(); //para indicar que não tem resposta
    }

}
/*
Agora é possivel deletar no postman
só selecionar delete no /users/numeroDoUserApagado
OBS: nessa altura do campeonato vai dar errado pois não houve tratamento de exceção
     e um objeto associado a outro (user tem pedidos) não pode ser apagado
 vai dar certo quando retornar um 204 noContent
*/