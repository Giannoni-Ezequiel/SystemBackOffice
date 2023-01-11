package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBienRepository extends JpaRepository<Bien, Integer> {

    /*public List<Bien> findAll();
    public Bien save(Bien bien);
    public int update(Bien bien);
    public int deleteById(int id);*/
}
