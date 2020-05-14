package com.mohamed.huisarts.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{


    @Column(name = "date_visit")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public LocalDate getDate() {
        return date;
    }
}
