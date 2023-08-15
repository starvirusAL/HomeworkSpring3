package app.controllers;

import app.Service.AccountService;
import app.Service.CustomerService;
import app.custom.TableHeader;
import app.models.Account;
import app.models.Customer;
import app.models.InputItems;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
public class CustomerController {
    private final EntityManager em;

    private final CustomerService customerService;

    private final AccountService accountService;

    @GetMapping("customCreate")
    public String customCreate() {
        return "customCreate";
    }

    @PostMapping("customCreate")
    public String customCreate(InputItems form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
        Account account = accountService.getAccountById(form.getIdAccount());
        Customer c = new Customer(form.getName(), form.getAge(), form.getEmail(), account);
        customerService.create(c);
        return "redirect:navigation";
    }



    /*@GetMapping("list")
    public String findAllStudentsWithJpql(Model model) {
        model.addAttribute("customer", customerService.findAll());
        return "listCustomer";

    }*/
    private Map<String, Object> data() {
        TableHeader th = new TableHeader("Id", "Name", "E-mail", "Account");
        List<Customer> tb = customerService.findAll();
        return Map.of(
                "thead", th,
                "tbody", tb
        );
    }
    @GetMapping("list")
    public String javaBooks1(Model model) {
        data().forEach((k, v) -> model.addAttribute(k, v));
        return "listCustomer";
    }

    @GetMapping("removeCustomer")
    public String removeCustomer() {
        return "removeCustomer";
    }

    @PostMapping("removeCustomer")

    public String removeCustomer(InputItems form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
        Customer customer = customerService.getCustomerById(form.getIdCustomer());
        customerService.delete(customer);
        return "redirect:navigation";
    }

    @GetMapping("remakeCustomer")
    public String remakeCustomer() {
        return "remakeCustomer";
    }

    @PostMapping("remakeCustomer")
    public String remakeCustomer(InputItems form, HttpServletRequest rq) {
        Map<String, String[]> allParams = rq.getParameterMap();
        Customer customer = customerService.getCustomerById(form.getIdCustomer());
        customerService.refactorCustomer(customer, form.getName(),form.getEmail(),form.getAge());
        customerService.create(customer);
        return "redirect:navigation";
    }

}