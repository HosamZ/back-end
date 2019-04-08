package at.nacs.drhouseaccountancy;

import lombok.Data;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Data
public class Invoice {

    @Id
    @GeneratedValue
    private Long id;

    //(fetch = EAGER)still not sure
    @ManyToOne
    private Patient patient;

    @Enumerated(EnumType.STRING)
    private Kind kind;

    private String symptoms;
    private String diagnosis;

    private String provided;

    private double cost;

    private boolean paid;

    @NotNull//needs L review
    private LocalDateTime timestamp;
}