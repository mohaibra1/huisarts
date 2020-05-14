package com.mohamed.huisarts.bootstrap;

import com.mohamed.huisarts.domain.Doctor;
import com.mohamed.huisarts.repositories.DoctorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements CommandLineRunner {

    private final DoctorRepository doctorRepository;

    public Dataloader(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Doctor doctor = new Doctor();
        doctor.setFirstName("Doc");
        doctor.setLastName("Loc");
        doctorRepository.save(doctor);
    }
}
