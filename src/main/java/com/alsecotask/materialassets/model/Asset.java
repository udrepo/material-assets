package com.alsecotask.materialassets.model;

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
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="employee_id", referencedColumnName="id")
    private Employee employee;
}
