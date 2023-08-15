package app.controllers;

import app.Service.EmployerService;
import app.models.Account;
import app.models.Employer;
import app.models.InputItems;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
public class EmployerController {

    private  final EmployerService service;

    @GetMapping("employerCreate")
    public String employerCreate() {
        return "employerCreate";
    }

    @PostMapping("employerCreate")
    public String employerCreate(InputItems form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
        Employer e = new Employer(form.getAddress(), form.getName());
        service.create(e);
        return "redirect:navigation";
    }

}
