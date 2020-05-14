package com.mohamed.huisarts.controller;

import com.mohamed.huisarts.domain.Patient;
import com.mohamed.huisarts.repositories.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class VisitControllerTest {

    private final String PATIENTS_CREATE_OR_UPDATE_VISIT_FORM = "patients/createOrUpdateVisitForm";


    @Mock
    PatientRepository patientRepository;

    @InjectMocks
    VisitController visitController;

    private MockMvc mockMvc;

    private final UriTemplate visitsUriTemplate  = new UriTemplate("/patients/{patientId}/visits/new");
    private final Map<String, String> uriVariables = new HashMap<>();
    private URI visitsUri;

    @BeforeEach
    void setUp() {

        Long patientsId = 1L;
        when(patientRepository.findById(anyLong())).thenReturn(Optional.of(Patient.builder().
                id(patientsId).
                firstName("Maohemd").
                lastName("Ali").
                address("Waterloostraat").
                city("Antwerpen").
                telephone("0492117785").
                email("Mimohadinho@Gmail.com").
                password("seanpaul").
                visits(new HashSet<>()).build()));

        uriVariables.clear();
        uriVariables.put("patientId", patientsId.toString());
        visitsUri = visitsUriTemplate.expand(uriVariables);

        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
    }


    @Test
    void initNewVisitForm() throws Exception {
        mockMvc.perform(get(visitsUri))
                .andExpect(status().isOk())
                .andExpect(view().name(PATIENTS_CREATE_OR_UPDATE_VISIT_FORM));
    }

    @Test
    void processNewVisitForm() throws Exception {
        mockMvc.perform(post(visitsUri)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("date", "10-11-2019")
                    .param("description", "Another visit"))
                .andExpect(status().isOk())
                .andExpect(view().name("patients/createOrUpdateVisitForm"))
                .andExpect(model().attributeExists("visit"));
    }
}