package org.example.security;

import lombok.RequiredArgsConstructor;

import org.example.entity.Users;
import org.example.repository.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrentUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = usersRepository.findByUsername(username);// stex ushadir linem karoxa es masy sxal lini
        if(optionalUsers.isEmpty()) {
            System.out.println("loginy kam passy sxala");
            throw new UsernameNotFoundException("UserName not found ");
        } else {
            System.out.println("arajin etapy ancav");
            return new CurrentUser(optionalUsers.get());
        }
    }
}
