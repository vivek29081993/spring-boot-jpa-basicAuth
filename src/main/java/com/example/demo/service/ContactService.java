package com.example.demo.service;

import com.example.demo.entity.json.AddContactRequest;
import com.example.demo.entity.ContactResponse;
import com.example.demo.entity.json.PhoneRequest;

import java.util.List;

/**
 * @author Vivek
 * @since 06/07/17
 */
public interface ContactService {

    long create(AddContactRequest addContactRequest,long userId);

    List<ContactResponse> listAll(long userId);

    long updateName(AddContactRequest addContactRequest,long id);

    void delete(long id);

    long addPhone(long id, PhoneRequest phoneRequest);

}
