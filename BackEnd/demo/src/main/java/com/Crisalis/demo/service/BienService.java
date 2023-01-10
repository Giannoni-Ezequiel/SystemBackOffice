package com.Crisalis.demo.service;

import com.Crisalis.demo.model.Bien;
import com.Crisalis.demo.repository.IBienRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BienService implements IBienRepository {

    @Autowired
    BienService BienRepo;

    @Override
    public List<Bien> findAll() {
        return null;
    }

    @Override
    public int save(Bien bien) {
        return 0;
    }

    @Override
    public int update(Bien bien) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }
}
