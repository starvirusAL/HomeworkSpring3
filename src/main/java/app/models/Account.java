package app.models;


import app.custom.RandomNumber;
import app.enums.Currency;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number = RandomNumber.randomDiceNumber();
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private Double balance = 0.0;

    @CreationTimestamp
    private LocalDateTime createdDateTime;
    @OneToMany(mappedBy = "account")
    private List<Account> account;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    public Account() {

    }

    public Account(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {

        return String.format("Cur:%s, Num:%s", currency, number);
    }
}

