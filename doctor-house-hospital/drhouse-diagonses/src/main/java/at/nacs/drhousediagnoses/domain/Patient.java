package at.nacs.drhousediagnoses.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Patient {

    String id;
    String name;
    String symptoms;
    String diagnosis;
}