package com.mohamed.huisarts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("credentials/login")
    public String login(){
        return "credentials/login";
    }

    @RequestMapping("credentials/registreren")
    public String registreren(){
        return "credentials/registreren";
    }

    @RequestMapping("credentials/contact")
    public String contact(){
        return "credentials/contact";
    }
}
