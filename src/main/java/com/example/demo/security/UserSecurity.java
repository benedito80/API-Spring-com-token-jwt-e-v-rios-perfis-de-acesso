package com.example.demo.security;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class UserSecurity {
    @Autowired
    UserRepository userRepo;

    public boolean hasUserId(Authentication authentication, Long userId) {
        Long userID = userRepo.findByUsername(authentication.getName()).getId();
        if (userID == userId) return true;
        return false;
    }

    public boolean adminDeleting(Authentication authentication, Long userId) {
        User user = userRepo.findByUsername(authentication.getName());

        //Se "admin" ele pode deletar outros ids, menos a condiçao do if abaixo..
        if (user.getId() != userId && "ADMIN".equals(user.getRoles())) {
            User userDel = userRepo.findById(userId).get();

            // Se usuario for "manager"... admin não pode deletar
            if ("MANAGER".equals(userDel.getRoles())) {
                return false;
            }
            return true;
        }
        return false;
    }
}

