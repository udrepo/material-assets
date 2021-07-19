package com.alsecotask.materialassets.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String fName;
    private String lName;

    public Employee(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }
}
