package pe.upc.finanzas.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import pe.upc.finanzas.proyecto.entities.Entidad;
import pe.upc.finanzas.proyecto.repository.EntidadRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class ClientController {
    @Autowired
    private EntidadRepository entidadRepository;

    //GET=>http:localthost:8080/api/entidades
    @GetMapping("/entidades")
    public ResponseEntity<List<Entidad>> getAllEntidades(){
        List<Entidad> entidades=entidadRepository.findAll();
        return new ResponseEntity<List<Entidad>>(entidades, HttpStatus.OK);
    }
}