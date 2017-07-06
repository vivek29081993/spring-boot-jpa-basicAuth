package com.example.demo.entity;

import java.util.Set;

/**
 * @author Vivek
 * @since 06/07/17
 */
public class ContactResponse {

    private String first_name;


    private String last_name;

    private Set<String> phones;

    private long  id;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static ContactResponse getContactResponse(Contact contact){
        ContactResponse cr = new ContactResponse();
        cr.setId(contact.getId());
        cr.setFirst_name(contact.getFirstName());
        cr.setLast_name(contact.getLastName());
        cr.setPhones(contact.getPhones());
        return cr;
    }
}
