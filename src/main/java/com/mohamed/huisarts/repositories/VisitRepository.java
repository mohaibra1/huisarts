package com.mohamed.huisarts.repositories;

import com.mohamed.huisarts.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    Visit findByDate(LocalDate localDate);
}
