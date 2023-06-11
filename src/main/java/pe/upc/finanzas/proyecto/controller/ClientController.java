package pe.upc.finanzas.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.finanzas.proyecto.entities.Client;
import pe.upc.finanzas.proyecto.entities.Client;
import pe.upc.finanzas.proyecto.exception.ResourceNotFoundException;
import pe.upc.finanzas.proyecto.exception.ValidationException;
import pe.upc.finanzas.proyecto.repository.ClientRepository;
import pe.upc.finanzas.proyecto.repository.UserRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")


public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    //GET=>http:localthost:8080/api/clients
    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients=clientRepository.findAll();
        return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }

    //GET=>http:localthost:8080/api/clients/1
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long id){
        Client client= clientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found client with id="+id));


        return new ResponseEntity<Client>(client,HttpStatus.OK);
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@RequestBody Client client){

        exitsClient(client);
        Client newclient= clientRepository.save(client);
        return new ResponseEntity<Client>(newclient,HttpStatus.CREATED);
    }
    private void exitsClient(Client client){
        if( clientRepository.existsClientByDni(client.getDni()) ){
            throw new ValidationException("“No se puede registrar la cuenta porque ya existe uno con estos datos");
        }
    }
    //PUT=>http:localthost:8080/api/clients/1
    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(
            @PathVariable("id") Long id,
            @RequestBody Client client) {
        Client clientUpdate = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found post with id=" + id));
        clientUpdate.setName(client.getName());

        return new ResponseEntity<Client>(clientRepository.save(clientUpdate),
                HttpStatus.OK);
    }
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") Long id){
        clientRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
