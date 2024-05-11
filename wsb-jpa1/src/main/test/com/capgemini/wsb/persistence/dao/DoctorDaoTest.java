package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.enums.Specialization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorDaoTest {

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private AddressDao addressDao;

    @Test
    public void testShouldFindDoctorById() {
        DoctorEntity doctor = doctorDao.findOne(1L);
        assertThat(doctor).isNotNull();
        assertThat(doctor.getFirstName()).isEqualTo("Adam");
    }

    @Transactional
    @Test
    public void testShouldDeleteAddressWhenDeleteDoctor() {
        DoctorEntity doctor = doctorDao.findOne(1L);
        AddressEntity address = addressDao.findOne(1L);

        assertThat(doctor).isNotNull();
        assertThat(address).isNotNull();

        doctorDao.delete(1L);
        assertThat(addressDao.findOne(address.getId())).isNull();
        assertThat(doctorDao.findOne(doctor.getId())).isNull();
    }


    @Test
    public void testShouldInsertDoctorAndAddress() {
        DoctorEntity doctor = new DoctorEntity();
        doctor.setDoctorNumber("321");
        doctor.setEmail("doctor@email.com");
        doctor.setFirstName("Piotr");
        doctor.setLastName("Piasta");
        doctor.setTelephoneNumber("997997997");
        doctor.setSpecialization(Specialization.OCULIST);

        AddressEntity address = new AddressEntity();
        address.setAddressLine1("Laczna");
        address.setAddressLine2("37");
        address.setCity("LipinkiLuzyckie");
        address.setPostalCode("98-432");

        doctor.setAddress(address);
        DoctorEntity savedDoctor = doctorDao.save(doctor);
        AddressEntity savedAddress = addressDao.findOne(savedDoctor.getAddress().getId());

        assertThat(savedDoctor).isNotNull();
        assertThat(savedAddress).isNotNull();

        assertThat(savedDoctor.getAddress().getCity()).isEqualTo("LipinkiLuzyckie");
    }
}