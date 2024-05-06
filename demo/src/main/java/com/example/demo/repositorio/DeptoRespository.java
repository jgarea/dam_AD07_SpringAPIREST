package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Depto;

import java.util.List;

@Repository
public interface DeptoRespository extends JpaRepository<Depto, Long> {

    @Query("select d from Depto d where d.nomdep not in (:nom1, :nom2)")
    List<Depto> findByNomdepIsNotAndNomdepIsNot(@Param("nom1") String nom1, @Param("nom2")  String nom2);
}
