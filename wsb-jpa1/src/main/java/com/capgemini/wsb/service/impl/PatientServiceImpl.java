package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.mapper.DoctorMapper;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.DoctorDao;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.dao.impl.DoctorDaoImpl;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import com.capgemini.wsb.service.DoctorService;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public PatientTO listPastVisits(Long id) {
        final PatientEntity patientEntity = patientDao.findOne(id);
        DoctorDao doctorDao = new DoctorDaoImpl();

        if (patientEntity != null) {
            List<VisitEntity> allVisits = patientEntity.getVisits();
            List<VisitEntity> pastVisits = new ArrayList<>();
            List<DoctorEntity> doctors = new ArrayList<>();
            LocalDate currentDate = LocalDate.now();
            for (VisitEntity visit : allVisits) {
                if (visit.getTime().toLocalDate().isBefore(currentDate)) {
                    pastVisits.add(visit);
                    DoctorEntity doctorEntity = visit.getDoctor();
                    doctors.add(doctorEntity);
                }
            }
            PatientTO patientTO = PatientMapper.mapToTo(patientEntity);
            patientTO.setVisits(pastVisits);
            patientTO.setDoctor(doctors);

            return patientTO;
        }
        return null;
    }
}
