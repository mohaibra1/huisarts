package com.mohamed.huisarts.controller;

import com.mohamed.huisarts.repositories.DoctorRepository;
import com.mohamed.huisarts.repositories.PatientRepository;
import com.mohamed.huisarts.repositories.VisitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/patients")
@Controller
public class PatientController {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final VisitRepository visitRepository;

    public PatientController(DoctorRepository doctorRepository, PatientRepository patientRepository, VisitRepository visitRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.visitRepository = visitRepository;
    }

    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setAllowedFields("id");
    }

    @RequestMapping("/afspraak")
    public String appointment(){
        return "patients/appointment";
    }


}
