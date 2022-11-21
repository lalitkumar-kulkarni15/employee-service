package com.employee.model;

import com.employee.entity.CompanyEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

import javax.persistence.Embedded;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Address address;
    private double salary;
    private Company company;

}
