package com.Crisalis.demo.service;

import com.Crisalis.demo.model.Bien;
import com.Crisalis.demo.repository.IBienRepository;
import com.Crisalis.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BienService {

    private final IBienRepository bienRepository;
    @Autowired
    public BienService(IBienRepository bienRepository){
        this.bienRepository = bienRepository;
    }
    public List<Bien> findAll() {
        return null;
    }
    public Bien save(Bien bien) {
        return bien;
    }
    public int update(Bien bien) {
        return 0;
    }
    public int deleteById(int id) {
        return 0;
    }
}
