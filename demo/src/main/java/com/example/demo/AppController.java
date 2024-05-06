package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/empleados")
@RequiredArgsConstructor
public class AppController {

    private final DeptoService deptoService;
    

    @PatchMapping("/cargar")
    public ResponseEntity<String> cargarDatos(){
        ArrayList<Depto> listaDeptos = new ArrayList<>();
      

        

        

        listaDeptos.add(new Depto("CONTABILIDAD", "SANTIAGO"));
        listaDeptos.add(new Depto("ADMINISTRACION", "VIGO"));
        listaDeptos.add(new Depto("VENTAS", "PONTEVEDRA"));
        listaDeptos.add(new Depto("OPERACIONES", "VILAGARCIA"));

        
        deptoService.guardar(listaDeptos.get(0));
       
        deptoService.guardar(listaDeptos.get(1));
        
        deptoService.guardar(listaDeptos.get(2));
       
        deptoService.guardar(listaDeptos.get(3));


        for (Depto depto : listaDeptos)
            deptoService.guardar(depto);

        return ResponseEntity.ok("Datos cargados correctamente");
    }

}