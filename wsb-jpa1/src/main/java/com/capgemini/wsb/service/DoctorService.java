package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.DoctorTO;

public interface DoctorService
{
    DoctorTO findById(final Long id);
}
