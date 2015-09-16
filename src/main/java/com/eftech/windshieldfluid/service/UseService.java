package com.eftech.windshieldfluid.service;

import java.util.List;
import com.eftech.windshieldfluid.model.Use;

public interface UseService {
    public Use create(Use use);
    public void delete(Use use);
    public List<Use> findAll();
    public Use update(Use use);
    public Use findById(int id);
}
