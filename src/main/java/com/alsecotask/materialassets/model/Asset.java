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
    private Long id;
    private String name;
    private double price;
    @ManyToOne
    private Employee employee;

}
