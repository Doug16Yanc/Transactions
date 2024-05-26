package douglas.transactions.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_effectuation_type")
public class EffectuationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "effectuation_type_id", unique = true)
    private Long id;

    @Column(name = "definition")
    private String definition;

    public EffectuationType(){

    }

    public EffectuationType(Long id, String definition) {
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

        public EffectuationType get() {
            return new EffectuationType(id, definition);
        }

    }
}
