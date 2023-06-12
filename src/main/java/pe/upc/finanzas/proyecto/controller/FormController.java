package pe.upc.finanzas.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.finanzas.proyecto.entities.Form;
import pe.upc.finanzas.proyecto.repository.FormRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class FormController {
    @Autowired
    private FormRepository formRepository;

    //GET=>http:localthost:8080/api/forms
    @GetMapping("/forms")
    public ResponseEntity<List<Form>> getAllForms(){
        List<Form> forms=formRepository.findAll();
        return new ResponseEntity<List<Form>>(forms, HttpStatus.OK);
    }

    @PostMapping("/forms")
    public ResponseEntity<Form> createForm(@RequestBody Form form){
        Form newForm=
                formRepository.save(form);
        return new ResponseEntity<Form>(newForm,HttpStatus.CREATED);
    }

}
