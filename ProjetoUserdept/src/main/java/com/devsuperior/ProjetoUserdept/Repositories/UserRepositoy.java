package com.devsuperior.ProjetoUserdept.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.ProjetoUserdept.Entites.User;
import java.util.List;


public interface UserRepositoy extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<User> searchUserByNameContainingIgnoreCase(String name);


}
