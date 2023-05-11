package com.adem.pc.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.adem.pc.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}