package app.models;


import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private String password;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    @OneToMany(mappedBy = "customer")
    private List<Customer> customer;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(mappedBy = "customers", cascade = {CascadeType.REMOVE})
    private Set<Employer> employers = new HashSet<>();

    public Customer() {

    }

    public Customer(String name, Integer age, String email, String phoneNumber,Account account) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }




    @Override
    public String toString() {
        return String.format("Id: %s Name: %s, Age: %s E-mail: %s, Acc: %s", id, name, age, email);
    }
}




