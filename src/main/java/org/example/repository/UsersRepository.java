package org.example.repository;



import org.example.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public interface UsersRepository  extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);

}
