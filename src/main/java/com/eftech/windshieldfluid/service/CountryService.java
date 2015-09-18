package com.eftech.windshieldfluid.service;

import java.util.List;
import com.eftech.windshieldfluid.model.Country;

public interface CountryService {
    //public Country create(Country country);
    public Country save(Country country);
    public void delete(Country country);
    public List<Country> findAll();
    //public Country update(Country country);
    public Country findById(Long id);
}
