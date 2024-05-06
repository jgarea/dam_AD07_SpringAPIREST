package com.example.demo.servicio;


import com.example.demo.*;
import com.example.demo.entidad.Depto;
import com.example.demo.repositorio.DeptoRespository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeptoService {

    private final DeptoRespository deptoRespository;

    public void guardar(Depto depto) {
        deptoRespository.save(depto);
    }

    public Depto addNewDepto(Depto depto){
        return deptoRespository.save(depto);
    }

    public Depto remove(Long id){
        Depto depto = deptoRespository.findById(id).orElse(null);
        deptoRespository.deleteById(id);
        return depto;
    }

    public Depto update(Depto depto){
        return deptoRespository.save(depto);
    }

    public List<Depto> findAll(){
        return deptoRespository.findAll();
    }

    public Depto findById(Long id) {
        return deptoRespository.findById(id).orElse(null);
    }

    public List<Depto> findByNomdepIsNotAndNomdepIsNot(String nomDep1, String nomDep2) {
        return deptoRespository.findByNomdepIsNotAndNomdepIsNot(nomDep1, nomDep2);
    }
}
