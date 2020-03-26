package com.mohamed.huisarts.repositories;

import com.mohamed.huisarts.domain.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    Visit findByID(Long id);

    Visit findbyDate(LocalDate localDate);
}
