package com.capgemini.wsb.persistence.service;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.service.impl.AddressServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceImplTest {

    @Autowired
    private AddressServiceImpl addressService;

    @Test
    public void testFindById() {

        AddressTO addressTO = addressService.findById(1L);

        assertThat(addressTO).isNotNull();
        assertThat(addressTO.getCity()).isEqualTo("Doctorowo");
    }
}