package com.capgemini.wsb.persistence.service;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.mapper.AddressMapper;
import com.capgemini.wsb.persistence.dao.AddressDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.service.impl.AddressServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


import static org.mockito.Mockito.when;

public class AddressServiceImplTest {

    @Mock
    private AddressDao addressDao;

    @InjectMocks
    private AddressServiceImpl addressService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindById() {
        // given
        Long addressId = 1L;
        AddressEntity mockedEntity = new AddressEntity();
        mockedEntity.setId(addressId);
        mockedEntity.setCity("Wroclaw");
        mockedEntity.setPostalCode("99-999");
        mockedEntity.setAddressLine1("Grabiszynka");
        mockedEntity.setAddressLine2("140");

        AddressTO expectedTO = AddressMapper.mapToTO(mockedEntity);

        // when
        when(addressDao.findOne(addressId)).thenReturn(mockedEntity);
        AddressTO foundTO = addressService.findById(addressId);

        // then
        assertThat(foundTO).isNotNull();
        assertThat(foundTO.getId()).isEqualTo(expectedTO.getId());
        assertThat(foundTO.getPostalCode()).isEqualTo(expectedTO.getPostalCode());

        // verify that addressDao.findOne(addressId) was called once
        verify(addressDao, times(1)).findOne(addressId);
    }
}