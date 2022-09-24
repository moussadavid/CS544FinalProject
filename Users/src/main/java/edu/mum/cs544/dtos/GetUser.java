package edu.mum.cs544.dtos;

import java.util.Date;

import edu.mum.cs544.entities.Address;

public class GetUser {
    private int id;
    private String keyCloakId;
    private String username;
    private String firstname;
    private String lastname;
    private Date dateOfBirth;
    private Address address;
}
