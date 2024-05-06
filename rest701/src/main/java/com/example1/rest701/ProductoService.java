package com.example1.rest701;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductoService {
    private final List<Producto> productos = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Producto> obtenerTodosLosProductos() {
        return productos;
    }

    public Producto obtenerProductoPorId(Long id) {
        return productos.stream()
                .filter(producto -> producto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void agregarProducto(Producto producto) {
        producto.setId(idCounter++);
        productos.add(producto);
    }

    public void eliminarProducto(Long id) {
        Iterator<Producto> iterator = productos.iterator();
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            if (producto.getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }
}
