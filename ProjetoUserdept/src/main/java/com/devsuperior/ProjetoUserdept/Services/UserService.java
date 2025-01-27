package com.devsuperior.ProjetoUserdept.Services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.ProjetoUserdept.Entites.User;
import com.devsuperior.ProjetoUserdept.Exceptions.RecourceNotFoundException;
import com.devsuperior.ProjetoUserdept.Repositories.UserRepositoy;

@Service
public class UserService {
    
    @Autowired
    private UserRepositoy userRepositoy;


    @Transactional(readOnly = true)
     public List<User> findAll(){
        return userRepositoy.findAll();

        
    }

    @Transactional(readOnly = true)
    public User findById(Long id){
       return userRepositoy.findById(id).get();
    
    }

    // @Transactional(readOnly = true)
    // public List<User> searchByName(String name){
    //     return userRepositoy.searchUserByNameContainingIgnoreCase(name);
    // }

    @Transactional
    public User insert(User u){
        User result = userRepositoy.save(u);

        return result;
    }

    @Transactional
    public void deletebyId(Long id){

        if (!userRepositoy.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }

         userRepositoy.deleteById(id);
    }

    @Transactional
    public User update(Long id, User u){
        User result = userRepositoy.findById(id).get();

        result.setName(u.getName());
        result.setEmail(u.getEmail());
        result.setDepartment(u.getDepartment());

        return userRepositoy.save(result);
    }
}
