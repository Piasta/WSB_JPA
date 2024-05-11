package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;

public final class DoctorMapper
{

    public static DoctorTO mapToTO(final DoctorEntity doctorEntity){
        if (doctorEntity == null){
            return null;
        }
        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setEmail(doctorEntity.getEmail());
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
        doctorEntity.setEmail(doctorTo.getEmail());
        return doctorEntity;
    }
}
