package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private DoctorDao doctorDao;

    @Test
    public void testShouldFindPatientById() {
        PatientEntity patient = patientDao.findOne(1L);
        assertThat(patient).isNotNull();
        assertThat(patient.getFirstName()).isEqualTo("Zuzanna");
    }

    @Transactional
    @Test
    public void testShouldDeletePatientByIdWithCascade() {
        PatientEntity patient = patientDao.findOne(1L);
        assertThat(patient).isNotNull();

        assertThat(patient.getVisits()).isNotNull();
        assertThat(patient.getAddress()).isNotNull();

        VisitEntity visit = visitDao.findOne(1L);
        VisitEntity visit2 = visitDao.findOne(2L);
        AddressEntity address = addressDao.findOne(2L);
        DoctorEntity doctor = doctorDao.findOne(1L);

        assertThat(patient.getVisits().get(0).getDescription()).isEqualTo(visit.getDescription());
        assertThat(patient.getVisits().get(1).getDescription()).isEqualTo(visit2.getDescription());
        assertThat(patient.getVisits().get(0).getDoctor().getFirstName()).isEqualTo(doctor.getFirstName());
        assertThat(patient.getAddress().getCity()).isEqualTo(address.getCity());

        patientDao.delete(1L);
        patient = patientDao.findOne(1L);
        visit = visitDao.findOne(1L);
        visit2 = visitDao.findOne(2L);
        address = addressDao.findOne(2L);
        doctor = doctorDao.findOne(1L);

        assertThat(patient).isNull();
        assertThat(visit).isNull();
        assertThat(visit2).isNull();
        assertThat(address).isNull();
        assertThat(doctor).isNotNull();
    }

    @Test
    public void testShouldFindPatientByLastName() {
        List<PatientEntity> patient = patientDao.findByLastName("Kasztan");
        assertThat(patient).isNotNull();
        assertThat(patient.size()).isEqualTo(1);
        assertThat(patient.get(0).getFirstName()).isEqualTo("Zuzanna");

        patient = patientDao.findByLastName("Piasta");
        assertThat(patient).isNotNull();
        assertThat(patient.size()).isEqualTo(2);
        assertThat(patient.get(0).getFirstName()).isEqualTo("Zygfryd");
        assertThat(patient.get(1).getFirstName()).isEqualTo("Bonifacy");
    }

    @Test
    public void testShouldFindPatientsWithQtyOfVisitsGreaterThan() {
        List<PatientEntity> patients = patientDao.findByNumberOfVisitsGreaterThan(1);
        assertThat(patients).isNotNull();
        assertThat(patients.size()).isEqualTo(1);

        patients = patientDao.findByNumberOfVisitsGreaterThan(0);
        assertThat(patients).isNotNull();
        assertThat(patients.size()).isEqualTo(2);
    }
}
