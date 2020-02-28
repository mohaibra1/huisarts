package com.mohamed.huisarts.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Patient  extends Person {

    private String address;

    private String city;

    private String telephone;

    //private Visit visit;

    public Patient() {

    }

    @Builder
    public Patient(Long id, String firstName, String lastName, String address, String city,
                   String telephone) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }
}