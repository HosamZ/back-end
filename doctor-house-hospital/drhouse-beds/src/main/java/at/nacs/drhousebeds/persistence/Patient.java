package at.nacs.drhousebeds.persistence;

import lombok.Data;

@Data
public class Patient {

    private String id;
    private String name;
    private String symptoms;
    private String diagnosis;
    private String treatment;
}