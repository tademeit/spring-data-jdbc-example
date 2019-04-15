package de.bit.tnohe.springdatajdbcexample.repository;

import de.bit.tnohe.springdatajdbcexample.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
