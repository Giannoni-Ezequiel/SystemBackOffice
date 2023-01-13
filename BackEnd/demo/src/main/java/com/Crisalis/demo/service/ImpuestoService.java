package com.Crisalis.demo.service;

import com.Crisalis.demo.exception.custom.EmptyElementException;
import com.Crisalis.demo.exception.custom.NotCreatedException;
import com.Crisalis.demo.model.Bien;
import com.Crisalis.demo.model.DTO.BienDTO;
import com.Crisalis.demo.model.DTO.ImpuestoDTO;
import com.Crisalis.demo.model.Impuesto;
import com.Crisalis.demo.repository.ImpuestoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpuestoService {

    private final ImpuestoRepository impuestoRepository;

    @Autowired
    public ImpuestoService(ImpuestoRepository impuestoRepository) {
        this.impuestoRepository = impuestoRepository;
    }

    public List<Impuesto> listar() {
        return (List<Impuesto>) this.impuestoRepository.findAll();
    }

    public Impuesto listarId(int id) {
        return this.impuestoRepository.findById(id).get();
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
