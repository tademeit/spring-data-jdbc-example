package de.bit.tnohe.springdatajdbcexample.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter@Setter
public class Customer {

    @Id
    Long id;

    String name;

    LocalDate dob;

    Gender gender;

}
