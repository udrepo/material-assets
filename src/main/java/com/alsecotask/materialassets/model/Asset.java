package com.alsecotask.materialassets.model;

import lombok.*;

import javax.persistence.*;

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
    private Long id;
    private String name;
    private double price;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


}
