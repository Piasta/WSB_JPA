package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;

public final class PatientMapper {

    public static PatientTO mapToTo(final PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setAddress(patientEntity.getAddress());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setVisits(patientEntity.getVisits());
        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        if (patientTO == null) {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setAddress(patientTO.getAddress());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setVisits(patientTO.getVisits());
        return patientEntity;
    }
}
