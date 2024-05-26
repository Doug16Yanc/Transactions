package douglas.transactions.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_effectuation")
public class Effectuation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "effectuation_id", unique = true)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;

    @JoinColumn(name = "effectuation_type_id")
    @ManyToOne
    private EffectuationType transactionType;

    public Effectuation() {

    }

    public Effectuation(String description, String email, String password, BigDecimal balance, EffectuationType transactionType) {
        this.description = description;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.transactionType = transactionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public EffectuationType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(EffectuationType transactionType) {
        this.transactionType = transactionType;
    }
}
