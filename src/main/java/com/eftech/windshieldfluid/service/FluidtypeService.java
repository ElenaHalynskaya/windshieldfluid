package com.eftech.windshieldfluid.service;

import java.util.List;
import com.eftech.windshieldfluid.model.FluidType;

public interface FluidtypeService {
    //public FluidType create(FluidType fluidType);
    public FluidType save(FluidType fluidType);
    public void delete(FluidType fluidType);
    public List<FluidType> findAll();
    //public FluidType update(FluidType fluidType);
    public FluidType findById(Long id);
}
