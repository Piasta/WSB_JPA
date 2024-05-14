package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;

public interface PatientService
{
    PatientTO findById(final Long id);

    PatientTO listPastVisits(final Long id);

    void delete (final Long id);
}
