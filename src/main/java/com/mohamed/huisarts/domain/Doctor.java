package com.mohamed.huisarts.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "doctor")
public class Doctor extends Person {

    @Builder
    public Doctor(Long id, String firstName, String lastName, Set<Patient> patients) {
        super(id, firstName, lastName);
        if(patients != null) {
            this.patients = patients;
        }
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private Set<Patient> patients = new HashSet<>();

}
