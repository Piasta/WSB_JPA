package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.VisitTO;

public interface VisitService
{
    VisitTO findById(final Long id);
}
