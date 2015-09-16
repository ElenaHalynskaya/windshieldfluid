package com.eftech.windshieldfluid.service;

import java.util.List;
import com.eftech.windshieldfluid.model.Capacity;

public interface CapacityService {
    public Capacity create(Capacity capacity);
    public void delete(Capacity capacity);
    public Capacity update(Capacity capacity);
    public List<Capacity> findAll();
    public Capacity findById(int id);
}
