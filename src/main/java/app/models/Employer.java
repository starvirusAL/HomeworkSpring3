package app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Employer")
public class Employer extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address;

    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "employee_customer",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "customer_id") })
    private Set<Customer> customers = new HashSet<>();

   public Employer(String name, String address){
        this.address = address;
        this.name = name;
    }
}
