package com.alsecotask.materialassets.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Asset {
    @Id
    @GeneratedValue
    @Type(type="uuid-char")
    private UUID id;
    private String name;
    private double price;
    @JsonBackReference
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="employee_id", referencedColumnName="id")
    private Employee employee;

    public Asset(String name, double price, Employee employee) {
        this.name = name;
        this.price = price;
        this.employee = employee;
    }
}
