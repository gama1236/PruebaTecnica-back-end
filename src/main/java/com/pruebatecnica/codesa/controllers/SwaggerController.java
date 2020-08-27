package com.pruebatecnica.codesa.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SwaggerController {
    @GetMapping
    public String gotoSwaggerUI() {
        return "redirect:/swagger-ui.html";
    }

}