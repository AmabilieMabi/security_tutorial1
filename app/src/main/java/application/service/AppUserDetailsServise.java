package application.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import application.model.User;
import application.repository.UserRepository;

@Service
public class AppUserDetailsServise implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Autowired

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user= userRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        UserDetails UserDetails= 
               org.springframework.security.core.userdetails.User.builder()
               .username(user.getUsername())
               .password(user.getPassword()) 
               .roles("USER")
               .build();

               return UserDetails;
    
    }

}
