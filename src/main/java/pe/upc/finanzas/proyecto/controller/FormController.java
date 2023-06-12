package pe.upc.finanzas.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.finanzas.proyecto.entities.Form;
import pe.upc.finanzas.proyecto.exception.ResourceNotFoundException;
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
                formRepository.save(
                        new Form(form.getClient_id(),
                                form.getCurrency(),
                                form.getEntity(),
                                form.getPrice(),
                                form.getInitial(),
                                form.getSustainable(),
                                form.getHelp(),
                                form.getTea(),
                                form.getSDegMensual(),
                                form.getSInmAnual(),
                                form.getTime(),
                                form.getGrace_period(),
                                form.getPer_initial(),
                                form.getBbb(),
                                form.getMontof(),
                                form.getTcea(),
                                form.getCuota()
                        )
                );
        return new ResponseEntity<Form>(newForm,HttpStatus.CREATED);
    }

}
