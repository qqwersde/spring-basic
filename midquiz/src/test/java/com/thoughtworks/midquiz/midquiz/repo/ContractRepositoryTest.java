package com.thoughtworks.midquiz.midquiz.repo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate"
})
class ContractRepositoryTest {
    @Autowired
    private ContractRepository contractRepository;

    @Test
    @Sql(value = {"classpath:sql/INSERT_TABLE_CONTRACT_ININT_DATA.sql"})
    public void should_exists_by_Id_works() {
        boolean existsById = contractRepository.existsById(1L);
        assertEquals(existsById, true);
    }

}