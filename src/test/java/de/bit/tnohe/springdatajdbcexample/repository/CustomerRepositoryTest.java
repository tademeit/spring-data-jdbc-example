package de.bit.tnohe.springdatajdbcexample.repository;

import de.bit.tnohe.springdatajdbcexample.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJdbcTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void test() {
        // Should save entity like JPA
        Customer customer = new Customer();
        customer.setName("Max Mustermann");
        Customer save = repository.save(customer);
        assertThat(save).isNotNull();
        assertThat(repository.count()).isEqualTo(1);

        //Spring Data JDBC thinks it is a new entity and save it again
        save.setId(null);
        repository.save(save);
        assertThat(repository.count()).isEqualTo(2);

        // No Caching active
        Optional<Customer> one = repository.findById(save.getId());
        Optional<Customer> two = repository.findById(save.getId());
        assertThat(one).isNotSameAs(two);

        //Derived Queries (no native support yet - needs query strings in repository)
        Customer maleCustomerOne = new Customer();
        maleCustomerOne.setGender("MALE");
        repository.save(maleCustomerOne);
        Customer maleCustomerTwo = new Customer();
        maleCustomerTwo.setGender("MALE");
        repository.save(maleCustomerTwo);
        Customer femaleCustomer = new Customer();
        femaleCustomer.setGender("FEMALE");
        repository.save(femaleCustomer);
        assertThat(repository.findByGender("MALE").size()).isEqualTo(2);
    }

}
