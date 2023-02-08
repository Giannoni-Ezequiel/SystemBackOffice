package com.Crisalis.demo.service;

import com.Crisalis.demo.exception.custom.NotFoundException;
import com.Crisalis.demo.model.DTO.ImpuestoDTO;
import com.Crisalis.demo.model.Impuesto;
import com.Crisalis.demo.repository.ImpuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpuestoService {

    private final ImpuestoRepository impuestoRepository;

    @Autowired
    public ImpuestoService(ImpuestoRepository impuestoRepository)
    {
        this.impuestoRepository = impuestoRepository;
    }
    public List<Impuesto> listar()
    {
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

    public Impuesto add(ImpuestoDTO imp)
    {
        return this.impuestoRepository.save(new Impuesto(imp));
    }
    public Impuesto edit(Integer id, Impuesto imp)
    {
        if(impuestoRepository.existsById(id)){
            imp.setImp_ID(id);
            Impuesto impActualizado = impuestoRepository.save(imp);
            return impActualizado;
        } else{
            throw new NotFoundException("Impuesto con ID " +id+" no existe");
        }

    }
    public void delete(int id)
    {
        if(impuestoRepository.existsById(id)){
            this.impuestoRepository.deleteById(id);
        } else {
            throw new NotFoundException("Impuesto con ID " +id+" no existe");
        }
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
