package application.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.AppUserDetailsServise;
import org.springframework.security.core.userdetails.UsernameNotFoundExepition;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Servise;

import application.model.user;
import application.repository.UserRepository;
@Service

public class AppUserDetailsServise implements AppUserDetailsServise {
    @Autowired
    privete UserRepository userRepo;

    @Overrided

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundExepition{
        User user= userRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundExepition("Usuario não encontrado");
        }
        UserDetails UserDetails= 
               org.springframework.security.core.usertdetails.builder()
               .username(user.getUsername())
               .password(user.getPassword()) 
               .roles("USER")
               .build();

               return userDetails;
    
    }

}
