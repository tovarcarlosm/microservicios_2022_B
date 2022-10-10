package co.edu.eam.negocio.servicio.controllers;

import co.edu.eam.negocio.servicio.entities.Categoria;
import co.edu.eam.negocio.servicio.entities.Servicio;
import co.edu.eam.negocio.servicio.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public ResponseEntity<List<Servicio>> listServicios(@RequestParam(name = "categoriaId", required = false) Long categoriaId){
        List<Servicio> servicios;
        if(categoriaId == null){
            servicios = servicioService.listAllServicio();
            if(servicios.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        } else {
            servicios = servicioService.findByCategoria(Categoria.builder().id(categoriaId).build());
            if(servicios.isEmpty()){
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.ok(servicios);
    }

}
