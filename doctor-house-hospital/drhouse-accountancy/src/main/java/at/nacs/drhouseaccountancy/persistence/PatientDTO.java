package at.nacs.drhouseaccountancy.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

  private String id;
  private String name;
  private String symptoms;
  private String diagnosis;
  private String treatment;
  private String medicine;
}