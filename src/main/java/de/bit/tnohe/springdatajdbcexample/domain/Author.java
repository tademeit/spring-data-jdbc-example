package de.bit.tnohe.springdatajdbcexample.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter@Setter
public class Author {

    @Id
    private Long id;

    private String name;
}
