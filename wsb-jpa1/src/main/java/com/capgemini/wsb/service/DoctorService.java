package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.DoctorTO;

public interface DoctorService
{
    public DoctorTO findById(final Long id);
}
