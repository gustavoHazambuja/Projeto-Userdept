package com.devsuperior.ProjetoUserdept.DTO;

import com.devsuperior.ProjetoUserdept.Entites.User;

public class UserDTO {
    
    private String name;

    public UserDTO(){

    }

    public UserDTO(User entity){
        this.name = entity.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
