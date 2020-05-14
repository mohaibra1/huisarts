package com.mohamed.huisarts.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
public class Patient  extends Person {

    @NotEmpty
    private String address;
    @NotEmpty
    private String city;
    @NotEmpty
    private String telephone;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;


    @Builder
    public Patient(Long id, String firstName, String lastName, String address, String city,
                   String telephone, String email, String password, Doctor doctor,Set<Visit> visits ) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.doctor = doctor;
    }

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private Set<Visit> visits = new HashSet<>();
}