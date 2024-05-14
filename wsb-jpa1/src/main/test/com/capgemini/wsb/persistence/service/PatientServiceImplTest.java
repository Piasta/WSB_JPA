package com.capgemini.wsb.persistence.service;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.AddressDao;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.VisitDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.impl.PatientServiceImpl;
import com.capgemini.wsb.service.impl.VisitServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PatientServiceImplTest {

    @Mock
    private PatientDao patientDao;

    @Mock
    private VisitDao visitDao;

    @Mock
    private DoctorDao doctorDao;

    @Mock
    private AddressDao addressDao;

    @InjectMocks
    private PatientServiceImpl patientService;

    @InjectMocks
    private VisitServiceImpl visitService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCascadeDelete() {

    }

    @Test
    public void testFindPatientById() {
        // given
        Long patientId = 1L;
        String firstName = "Sprytny";
        String lastName = "Johny";

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientId);
        patientEntity.setFirstName(firstName);
        patientEntity.setLastName(lastName);

        // when
        when(patientDao.findOne(patientId)).thenReturn(patientEntity);

        PatientTO patientTO = patientService.findById(patientId);

        // then
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getId()).isEqualTo(patientId);
        assertThat(patientTO.getFirstName()).isEqualTo(firstName);
        assertThat(patientTO.getLastName()).isEqualTo(lastName);
    }
}
