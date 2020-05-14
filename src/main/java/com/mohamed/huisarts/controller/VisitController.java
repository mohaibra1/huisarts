package com.mohamed.huisarts.controller;

import com.mohamed.huisarts.domain.Patient;
import com.mohamed.huisarts.domain.Visit;
import com.mohamed.huisarts.repositories.PatientRepository;
import com.mohamed.huisarts.repositories.VisitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

@Controller
public class VisitController {

    private static final String PATIENTS_CREATE_OR_UPDATE_VISIT_FORM = "patients/createOrUpdateVisitForm";
    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;

    public VisitController(VisitRepository visitRepository, PatientRepository patientRepository) {
        this.visitRepository = visitRepository;
        this.patientRepository = patientRepository;
    }

    @InitBinder
    public void dataBinder(WebDataBinder dataBinder) {
        //dataBinder.setDisallowedFields("id");

        dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException{
                setValue(LocalDate.parse(text));
            }
        });
    }

    @ModelAttribute("visit")
    public Visit loadPetWithPetVisit(@PathVariable Long patientId, Model model){
        Patient foundPatient = patientRepository.findById(patientId).orElse(null);
        model.addAttribute("foundPatient", foundPatient);
        Visit visit = new Visit();
        foundPatient.getVisits().add(visit);
        visit.setPatient(foundPatient);
        System.out.println("Visits added");
        return visit;
    }

    @GetMapping("/patients/{patientId}/visits/new")
    public String initNewVisitForm(Model model){
        return PATIENTS_CREATE_OR_UPDATE_VISIT_FORM;
    }

    @PostMapping("/patients/{patientId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result){
        if(result.hasErrors()){
            return PATIENTS_CREATE_OR_UPDATE_VISIT_FORM;
        }
        else{
            //Patient foundPatient = patientRepository.findById(patientId).orElse(null);
            //model.addAttribute("foundPatient", foundPatient);
            visitRepository.save(visit);
            return "patients/user";
        }
    }

}
