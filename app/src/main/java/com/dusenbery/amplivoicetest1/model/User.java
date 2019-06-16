package com.dusenbery.amplivoicetest1.model;

import com.google.firebase.firestore.IgnoreExtraProperties;

/**
 * User POJO (Plain Old Java Object)
 */
@IgnoreExtraProperties
public class User {
    public static final String FIELD_FIRST_NAME = "firstName";
    public static final String FIELD_LAST_NAME = "lastName";


    private String firstName;
    private String lastName;

    public User() {}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
