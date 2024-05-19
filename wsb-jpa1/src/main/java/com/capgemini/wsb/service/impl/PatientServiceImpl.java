package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.rest.exception.EntityNotFoundException;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService
{

    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao) { patientDao = pPatientDao; }

    @Override
    public PatientTO findById(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTo(entity);
    }

    @Override
    public PatientTO listAllVisits(Long id) {
        final PatientEntity entity = patientDao.findOne(id);

        if (entity != null) {
            List<VisitEntity> allVisits = entity.getVisits();
            PatientTO patientTO = PatientMapper.mapToTo(entity);
            patientTO.setVisits(allVisits);
            return patientTO;
        }
        return null;
    }

    @Override
    public PatientTO listPastVisits(Long id) {
        final PatientEntity patientEntity = patientDao.findOne(id);

        if (patientEntity != null) {
            List<VisitEntity> allVisits = patientEntity.getVisits();
            List<VisitEntity> pastVisits = new ArrayList<>();
            LocalDate currentDate = LocalDate.now();
            for (VisitEntity visit : allVisits) {
                if (visit.getTime().toLocalDate().isBefore(currentDate)) {
                    pastVisits.add(visit);
                }
            }
            PatientTO patientTO = PatientMapper.mapToTo(patientEntity);
            patientTO.setVisits(pastVisits);

            return patientTO;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        final PatientEntity entity = patientDao.findOne(id);
        if (entity != null) {
            patientDao.delete(entity.getId());
        } else {
            throw new EntityNotFoundException(id);
        }
    }
}
