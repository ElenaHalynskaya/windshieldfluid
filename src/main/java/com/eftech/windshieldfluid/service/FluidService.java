package com.eftech.windshieldfluid.service;

import java.util.List;
import com.eftech.windshieldfluid.model.Fluid;

public interface FluidService {
    public Fluid create(Fluid fluid);
    public void delete(Fluid fluid);
    public List<Fluid> findAll();
    public Fluid update(Fluid fluid);
    public Fluid findById(int id);
}
