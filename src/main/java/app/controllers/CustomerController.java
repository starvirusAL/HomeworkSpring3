package app.controllers;

import app.Service.AccountService;
import app.Service.CustomerService;
import app.custom.TableHeader;
import app.dto.CustomerMapper;
import app.dto.CustomerRequest;
import app.dto.CustomerResponseDto;
import app.models.Account;
import app.models.Customer;
import app.models.InputItems;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Log4j2
@RequiredArgsConstructor
public class CustomerController {
    private final EntityManager em;

    private final CustomerService customerService;

    private final AccountService accountService;
    private final CustomerMapper dtoCustomerMapper;
    @GetMapping("customer")
    @ResponseBody
    public List<CustomerResponseDto> handleGet() {
        return customerService.showAll();
    }

    @GetMapping("customer/{page}/{size}")
    @ResponseBody
    public ResponseEntity<?> handleGet(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        List<Customer> customers = customerService.showAllPage(page, size);
        List<CustomerResponseDto> departmentsDto = customers.stream().map(dtoCustomerMapper::convertToDto).collect(Collectors.toList());
        return ResponseEntity.ok(departmentsDto);
    }

    @GetMapping("customer-create")
    public String customCreate(CustomerRequest customerRequest) {
        return "customer-create";
    }

    @PostMapping("customer-create")
    public String customCreate(InputItems form, HttpServletRequest rq, @Valid CustomerRequest customerRequest, BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(System.out::println);
            return "customer-create";
        }
        Account account = accountService.getAccountById(form.getIdAccount());
        Customer customer = new Customer(form.getName(), form.getAge(), form.getEmail(), form.getPhoneNumber(), account);

        customerService.create(customer);
        return "redirect:navigation";
    }


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