package de.bit.tnohe.springdatajdbcexample.repository;

import de.bit.tnohe.springdatajdbcexample.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJdbcTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void test() {
        Customer customer = new Customer();
        customer.setName("Timo");

        Customer save = repository.save(customer);

        assertThat(save).isNotNull();
    }

}
