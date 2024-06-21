package org.example.security;



import org.example.entity.Users;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {
    private Users users ;
    public CurrentUser(Users users) {
        super(users.getUsername(), users.getPassword(), AuthorityUtils.createAuthorityList(users.getRole().name()));
        this.users = users;
        System.out.println("2 etapy ancav " + users.getUsername() +AuthorityUtils.createAuthorityList(users.getRole().name()));
    }
    public Users getUsers() {
        return users;
    }
}
