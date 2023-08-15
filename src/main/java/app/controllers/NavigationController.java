package app.controllers;

import app.models.InputItems;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Log4j2
public class NavigationController {
    @GetMapping("navigation")
    public String moneyPut() {
        return "navigation";
    }

    @PostMapping("navigation")

    public String navigation(InputItems form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
        if (form.getCheckPage() == 0) return "redirect:personalInformation";
        if (form.getCheckPage() == 1) return "redirect:accountCreate";
        if (form.getCheckPage() == 2) return "redirect:customCreate";
        if (form.getCheckPage() == 3) return "redirect:list";
        if (form.getCheckPage() == 4) return "redirect:putMoney";
        if (form.getCheckPage() == 5) return "redirect:withdrawMoney";
        if (form.getCheckPage() == 6) return "redirect:transferMoney";
        if (form.getCheckPage() == 7) return "redirect:removeCustomer";
        if (form.getCheckPage() == 8) return "redirect:removeAccount";
        if (form.getCheckPage() == 9) return "redirect:remakeCustomer";
        if (form.getCheckPage() == 10) return "redirect:balance";
        if (form.getCheckPage() == 11) return "redirect:employerCreate";
        return "redirect:navigation";
    }
}
