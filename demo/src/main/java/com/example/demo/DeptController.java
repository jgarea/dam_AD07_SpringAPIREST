package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entidad.Depto;
import com.example.demo.servicio.DeptoService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empleados/depto")
@RequiredArgsConstructor
public class DeptController {

    private final DeptoService deptoService;

    @GetMapping
    public List<Depto> obtenerDepartamentos() {
        return deptoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Depto> obtenerDepartamentoPorId(@PathVariable Long id) {
        Depto departamento = deptoService.findById(id);
        return ResponseEntity.ok(departamento);
    }

    @PostMapping
    public ResponseEntity<String> crearDepartamento(@RequestBody Depto departamento) {
        deptoService.guardar(departamento);
        return ResponseEntity.status(HttpStatus.CREATED).body("Departamento guardado correctamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Depto> modificarDepartamento(@PathVariable Long id, @RequestBody Depto departamentoActualizado) {
        Depto departamento = deptoService.findById(id);
        if (departamento != null) {
            departamentoActualizado.setNumdep(id);
            deptoService.guardar(departamento);
            return ResponseEntity.ok(departamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
