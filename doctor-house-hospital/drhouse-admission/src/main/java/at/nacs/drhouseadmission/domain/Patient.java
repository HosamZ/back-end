package at.nacs.drhouseadmission.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
  private String id;
  private String name;
  private String symptoms;
}