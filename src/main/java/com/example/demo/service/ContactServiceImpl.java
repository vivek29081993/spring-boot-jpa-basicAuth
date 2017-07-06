package com.example.demo.service;

import com.example.demo.entity.json.AddContactRequest;
import com.example.demo.entity.Contact;
import com.example.demo.entity.ContactResponse;
import com.example.demo.entity.json.PhoneRequest;
import com.example.demo.exception.ContactNotFoundException;
import com.example.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vivek
 * @since 06/07/17
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public long create(AddContactRequest addContactRequest,long userId) {
        Contact contact = new Contact();
        contact.setFirstName(addContactRequest.getFirst_name());
        contact.setLastName(addContactRequest.getLast_name());
        contact.setUserId(userId);
        contact.setPhones(addContactRequest.getPhones());

        Contact saved = contactRepository.save(contact);
        return saved.getId();

    }

    @Override
    public List<ContactResponse> listAll(long userId) {
    List<Contact> contacts = contactRepository.findByUserId(userId);
    return contacts.stream().map(ContactResponse::getContactResponse).collect(Collectors.toList());
    }

    @Override
    public long updateName(AddContactRequest addContactRequest, long id) {

        Contact contact = contactRepository.findOne(id);
        if(contact == null){
            throw new ContactNotFoundException(String.format("No contact found with id '%s'.", id));
        }
        contact.setFirstName(addContactRequest.getFirst_name());
        contact.setLastName(addContactRequest.getLast_name());
        contactRepository.save(contact);
        return contact.getId();
    }

    @Override
    public void delete(long id) {
        Contact contact = contactRepository.findOne(id);
        if(contact == null){
            throw new ContactNotFoundException(String.format("No contact found with id '%s'.", id));
        }
        contactRepository.delete(id);
    }

    @Override
    public long addPhone(long id, PhoneRequest phoneRequest) {

        Contact contact = contactRepository.findOne(id);
        if(contact == null){
            throw new ContactNotFoundException(String.format("No contact found with id '%s'.", id));
        }
        contact.getPhones().add(phoneRequest.getPhone());
        contactRepository.save(contact);
        return contact.getId();
    }
}
