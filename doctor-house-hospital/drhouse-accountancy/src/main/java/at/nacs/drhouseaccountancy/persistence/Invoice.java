package at.nacs.drhouseaccountancy.persistence;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
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

  //  @NotNull//needs L review
  private LocalDateTime timestamp;
}