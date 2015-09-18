package com.eftech.windshieldfluid.service;

import java.util.List;
import com.eftech.windshieldfluid.model.Manufacturer;

public interface ManufacturerService {
    //public Manufacturer create(Manufacturer manufacturer);
    public Manufacturer save(Manufacturer manufacturer);
    public void delete(Manufacturer manufacturer);
    public List<Manufacturer> findAll();
    //public Manufacturer update(Manufacturer manufacturer);
    public Manufacturer findById(Long id);
}
