package douglas.transactions.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_transaction_type")
public class TransactionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_type_id", unique = true)
    private Long id;

    @Column(name = "definition")
    private String definition;

    public TransactionType(){

    }

    public TransactionType(Long id, String definition) {
        this.id = id;
        this.definition = definition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public enum Enum {
        OWNER(1L, "owner"),
        USER(2L, "user");


        private Long id;
        private String definition;

        Enum(Long id, String definition) {
            this.id = id;
            this.definition = definition;
        }

        public TransactionType get() {
            return new TransactionType(id, definition);
        }

    }
}
