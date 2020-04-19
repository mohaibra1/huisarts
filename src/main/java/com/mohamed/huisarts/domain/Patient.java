package com.mohamed.huisarts.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Patient")
public class Patient  extends Person {

    private String address;
    private String city;
    private String telephone;
    private String email;
    private String password;


    @Builder
    public Patient(Long id, String firstName, String lastName, String address, String city,
                   String telephone, String email, String password, Set<Visit> visits ) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
    }

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Set<Visit> visits = new HashSet<>();
}