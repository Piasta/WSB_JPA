package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

public final class DoctorMapper
{

    public static DoctorTO mapToTo(final DoctorEntity doctorEntity){
        if (doctorEntity == null){
            return null;
        }
        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setDoctorNumber(doctorEntity.getDoctorNumber());
        doctorTO.setSpecialization(doctorEntity.getSpecialization());
        doctorTO.setAddress(doctorEntity.getAddress());
        doctorTO.setVisits(doctorEntity.getVisits());
        return doctorTO;
    }

    public static DoctorEntity mapToEntity(final DoctorTO doctorTo){
        if (doctorTo == null){
            return null;
        }
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorTo.getId());
        doctorEntity.setFirstName(doctorTo.getFirstName());
        doctorEntity.setLastName(doctorTo.getLastName());
        doctorEntity.setTelephoneNumber(doctorTo.getTelephoneNumber());
        doctorEntity.setEmail(doctorTo.getEmail());
        doctorEntity.setDoctorNumber(doctorTo.getDoctorNumber());
        doctorEntity.setSpecialization(doctorTo.getSpecialization());
        doctorEntity.setAddress(doctorTo.getAddress());
        doctorEntity.setVisits(doctorTo.getVisits());
        return doctorEntity;
    }
}
