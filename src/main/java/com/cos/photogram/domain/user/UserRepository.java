package com.cos.photogram.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

// Automatically applied to IoC when it extends JpaRepository
public interface UserRepository extends JpaRepository<User, Integer> {

    // JPA query method
    User findByUsername(String username);

}
