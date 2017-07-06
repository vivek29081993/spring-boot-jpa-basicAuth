package com.example.demo.entity.json;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Set;

/**
 * @author Vivek
 * @since 06/07/17
 */
public class AddContactRequest {

    @NotBlank
    private String first_name;

    @NotBlank
    private String last_name;

    private Set<String> phones;

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
}
