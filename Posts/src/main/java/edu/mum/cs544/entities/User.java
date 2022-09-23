package edu.mum.cs544.entities;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String keyCloakId;
    private String firstname;
    private String lastname;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Embedded
    private Address address;
}
