package com.mohamed.huisarts.controller;

import com.mohamed.huisarts.comands.LoginComand;
import com.mohamed.huisarts.domain.Patient;
import com.mohamed.huisarts.repositories.DoctorRepository;
import com.mohamed.huisarts.repositories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;

@Controller
public class LoginController {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public LoginController(PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    /*@InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setAllowedFields("id");
    }*/

    @RequestMapping("credentials/login")
    public String displayLogin(Model model){

        model.addAttribute("loginComand", new LoginComand());

        return "credentials/login";
    }


    @RequestMapping(value = "/afspraak", method = RequestMethod.POST)
    public String displayUserInfo(@Valid LoginComand loginComand, BindingResult bindingResult, Model model){

            if(bindingResult.hasErrors()){
                for(int i = 0; i < bindingResult.getAllErrors().size(); i++){
                    System.out.println(bindingResult.getAllErrors().get(i));
                }
                return "/credentials/login";
            }

        //System.out.println(loginComand.getEmail());

        Patient foundPatient = patientRepository.findByEmail(loginComand.getEmail());
        System.out.println(foundPatient.getLastName() + " " + foundPatient.getDoctor().getFirstName());

        model.addAttribute("foundPatient", patientRepository.findByEmail(loginComand.getEmail()));

        if((foundPatient.getEmail().equals(loginComand.getEmail())) && foundPatient.getPassword().equals(loginComand.getPassword())) {
            return "/patients/user";
        }
        System.out.println("Login is niet gelukt");

        return "/credentials/login";
    }

    @RequestMapping("credentials/registreren")
    public String registreren(Model model){

        model.addAttribute("patient" , Patient.builder().build());

        return "credentials/registreren";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createNewPatient(@Valid Patient patient, BindingResult bindingResult){

        if(bindingResult.hasErrors()) {
            for(int i = 0; i < bindingResult.getAllErrors().size(); i++){
                System.out.println(bindingResult.getAllErrors().get(i));
            }
            return "credentials/registreren";
        }
            else {
            patient.setDoctor(doctorRepository.findByLastName("Loc"));
            Patient savedPatient = patientRepository.save(patient);

            System.out.println(patient.getLastName());
            return "redirect:" + "/credentials/login";
        }

    }

    @GetMapping("credentials/contact")
    public String contact(){
        return "credentials/contact";
    }

}
