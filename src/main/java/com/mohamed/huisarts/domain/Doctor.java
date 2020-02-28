package com.mohamed.huisarts.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Doctor extends Person {


    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    //private Set<Patient> patients = new HashSet<>();

}
