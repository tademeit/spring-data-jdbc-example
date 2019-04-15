package de.bit.tnohe.springdatajdbcexample.repository;

import de.bit.tnohe.springdatajdbcexample.domain.Customer;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("SELECT * FROM Customer WHERE Gender = :gender")
    List<Customer> findByGender(@Param("gender") String gender);

}
