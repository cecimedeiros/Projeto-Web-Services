package com.loribusiness.testesEstudo.services;

import com.loribusiness.testesEstudo.entities.User;
import com.loribusiness.testesEstudo.repositories.UserRepository;
import com.loribusiness.testesEstudo.services.exceptions.DatabaseException;
import com.loribusiness.testesEstudo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional <User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
        //esse orElseThrow é tipo "cata lá, se não tiver joga exceção na cara"
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }


    public User update(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmanil(obj.getEmanil());
        entity.setPhone(obj.getPhone());
    }

}
