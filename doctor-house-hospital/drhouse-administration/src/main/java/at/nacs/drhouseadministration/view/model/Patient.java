package at.nacs.drhouseadministration.view.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Patient {

  private String id;
  @NotEmpty
  private String name;
  @NotEmpty
  private String symptoms;
  private String diagnosis;
  private String medicine;
}
