package com.alsecotask.materialassets.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
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
   @GeneratedValue
    @Type(type="uuid-char")
    private UUID id;
    private String firstName;
    private String lastName;
    @OneToMany(targetEntity = Asset.class,cascade = CascadeType.ALL)
    @JoinColumn(name="employee_id", referencedColumnName="id")
    private List<Asset> assets;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, List<Asset> assets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.assets = assets;
    }
}
