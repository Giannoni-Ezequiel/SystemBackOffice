package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Bien;

import java.util.List;

public interface IBienRepository {

    public List<Bien> findAll();
    public int save(Bien bien);
    public int update(Bien bien);
    public int deleteById(int id);
}
