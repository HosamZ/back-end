package at.nacs.drhouseaccountancy.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String uuid;

  @Column(unique = true)
  private String name;
}