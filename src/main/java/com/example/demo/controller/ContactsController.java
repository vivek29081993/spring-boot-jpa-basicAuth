package com.example.demo.controller;

import com.example.demo.entity.json.AddContactRequest;
import com.example.demo.entity.json.PhoneRequest;
import com.example.demo.entity.secure.CustomUser;
import com.example.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author Vivek
 * @since 04/07/17
 */
@RestController
@RequestMapping("/contacts")
@PreAuthorize("@securityService.hasProtectedAccess()")
public class ContactsController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAllContacts(){

        long userId = ((CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return ResponseEntity.ok(contactService.listAll(userId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createContact(@RequestBody AddContactRequest addContactRequest){
        long userId = ((CustomUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return ResponseEntity.ok(contactService.create(addContactRequest,userId));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{contacts_id}")
    public ResponseEntity delete(@PathVariable("contacts_id") Long contactId){

        try {
            contactService.delete(contactId);
        }catch (Throwable th){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok("Deleted Successfully");
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{contacts_id}")
    public ResponseEntity<?> updateContact(@PathVariable("contacts_id") Long contactId,@RequestBody AddContactRequest addContactRequest){
        long id;
        try {
            id = contactService.updateName(addContactRequest,contactId);
        } catch (Throwable th){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(id);
    }

    @RequestMapping(path = "/entries/{contacts_id}",method = RequestMethod.POST)
    public ResponseEntity<?> updatePhone(@PathVariable("contacts_id") Long contactId,@RequestBody PhoneRequest phoneRequest){
        long id;
        try {
            id = contactService.addPhone(contactId,phoneRequest);
        } catch (Throwable th){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(id);
    }

}
