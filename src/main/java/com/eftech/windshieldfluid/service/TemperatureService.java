package com.eftech.windshieldfluid.service;

import java.util.List;
import com.eftech.windshieldfluid.model.Temperature;

public interface TemperatureService {
   // public Temperature create(Temperature temperature);
    public Temperature save(Temperature temperature);
    public void delete(Temperature temperature);
    public List<Temperature> findAll();
    //public Temperature update(Temperature temperature);
    public Temperature findById(Long id);
}
