package com.employee.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Address {

    private String street;
    private String landmark;
    private String postalCode;
}
