package com.mohamed.huisarts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class DokterController {

    @GetMapping("dokters/dokter")
    public String logDokterIn(){
        return "dokters/dokter";
    }


}
