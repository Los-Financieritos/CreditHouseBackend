package pe.upc.finanzas.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.finanzas.proyecto.entities.User;
import pe.upc.finanzas.proyecto.exception.ResourceNotFoundException;
import pe.upc.finanzas.proyecto.repository.UserRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    private UserRepository userRepository;

    //GET=>http:localthost:8080/api/users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userRepository.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    //GET=>http:localthost:8080/api/users/1
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user= userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found user with id="+id));


        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser=
                userRepository.save(
                        new User(user.getName(),
                                user.getLastname(),
                                user.getUsername(),
                                user.getCompany(),
                                user.getEmail(),
                                user.getPassword()
                                )
                );
        return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
    }
    //PUT=>http:localthost:8080/api/users/1
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable("id") Long id,
            @RequestBody User user) {
        User userUpdate = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found post with id=" + id));
        userUpdate.setName(user.getName());
        userUpdate.setLastname(user.getLastname());
        userUpdate.setUsername(user.getUsername());
        userUpdate.setCompany(user.getCompany());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());



        return new ResponseEntity<User>(userRepository.save(userUpdate),
                HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/users/{id}/upgrade")
    public ResponseEntity<User> updatePassword(
            @PathVariable("id") Long id,
            @RequestBody String password){
        User userUpdate= userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found post with id="+id));
        userUpdate.setPassword(password);

        return new ResponseEntity<User>(userRepository.save(userUpdate),
                HttpStatus.OK);
    }
}
