package com.example.demo.repository;

import com.example.demo.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Vivek
 * @since 06/07/17
 */
@Repository
public interface ContactRepository extends CrudRepository<Contact,Long> {

    List<Contact> findByUserId(long userId);
}
