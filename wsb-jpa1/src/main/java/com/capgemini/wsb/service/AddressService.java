package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.AddressTO;

public interface AddressService
{
    AddressTO findById(final Long id);
}
