package com.Crisalis.demo.service;

import com.Crisalis.demo.model.DTO.ImpuestoDTO;
import com.Crisalis.demo.model.Impuesto;
import com.Crisalis.demo.repository.ImpuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpuestoService {

    private final ImpuestoRepository impuestoRepository;

    @Autowired
    public ImpuestoService(ImpuestoRepository impuestoRepository) {
        this.impuestoRepository = impuestoRepository;
    }
    public List<Impuesto> listar() {
        return this.impuestoRepository.findAll();
    }

    public Impuesto listarId(int id) {
        Optional<Impuesto> impuesto = this.impuestoRepository.findById(id);
        Impuesto Retornar = null;
        if(impuesto.isPresent()){
            Retornar = impuesto.get();
        }
        return Retornar;
    }

    public void add(ImpuestoDTO imp) {
            this.impuestoRepository.save(imp.toImpuestoEntity());
    }
    public Impuesto edit(ImpuestoDTO imp) {
        return this.impuestoRepository.save(imp.toImpuestoEntity());
    }
    public Impuesto delete(int id) {
        this.impuestoRepository.deleteById(id);
        return null;
    }
    /*
    private Boolean checkImpuesto(ImpuestoDTO impuestoDTO, boolean check){
        if(!check) {
            if (StringUtils.isEmpty(impuestoDTO.getImp_Nombre())) {
                throw new EmptyElementException("Nombre is empty");
            }
            if (impuestoDTO.getImp_Porcentaje() == null) {
                throw new EmptyElementException("Porcentaje is empty");
            }
        }
        return Boolean.TRUE;
    }

     */

}
