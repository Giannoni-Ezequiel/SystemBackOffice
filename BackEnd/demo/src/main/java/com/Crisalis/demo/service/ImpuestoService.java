package com.Crisalis.demo.service;

import com.Crisalis.demo.exception.custom.EmptyElementException;
import com.Crisalis.demo.exception.custom.NotCreatedException;
import com.Crisalis.demo.model.DTO.ImpuestoDTO;
import com.Crisalis.demo.model.Impuesto;
import com.Crisalis.demo.repository.ImpuestoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpuestoService {

    private final ImpuestoRepository impuestoRepository;

    @Autowired
    public ImpuestoService(ImpuestoRepository impuestoRepository) {
        this.impuestoRepository = impuestoRepository;
    }

    public Impuesto saveImpuesto(ImpuestoDTO impuestoDTO){
        if(checkImpuesto(impuestoDTO, Boolean.FALSE)){
            return this.impuestoRepository.save(new Impuesto(impuestoDTO));
        }
        throw new NotCreatedException("Error en guardar impuesto");
    }

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
}
