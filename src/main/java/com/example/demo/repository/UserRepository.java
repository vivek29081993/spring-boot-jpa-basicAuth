package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vivek
 * @since 04/07/17
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    public User findByUsername(String username);
}
