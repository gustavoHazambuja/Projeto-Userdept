package com.devsuperior.ProjetoUserdept.Controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.ProjetoUserdept.Entites.User;
import com.devsuperior.ProjetoUserdept.Exceptions.RecourceNotFoundException;
import com.devsuperior.ProjetoUserdept.Services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public User findbyId(@PathVariable Long id){
       return userService.findById(id);
    }

    // @GetMapping(value = "/{name}")
    // public List<User> serchByyName(@PathVariable String name){
    //     return userService.searchByName(name);
    // }

    @PostMapping
    public User insert(@RequestBody User u){
        User result = userService.insert(u);

        return result;
    }

    @PutMapping(value = "/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User u){
        return userService.update(id, u);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id){

        userService.deletebyId(id);
    }
}
