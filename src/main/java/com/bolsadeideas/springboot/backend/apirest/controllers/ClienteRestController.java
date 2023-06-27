/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.bolsadeideas.springboot.backend.apirest.controllers;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import com.bolsadeideas.springboot.backend.apirest.models.services.IClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.function.EntityResponse;

/**
 *
 * @author F.J. BOGA
 */
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {
    
    @Autowired
    private IClientService clientService;
    
    @GetMapping("/clientes")
    public List<Cliente> index(){
        return clientService.findAll();
    }
    
    @GetMapping(path = "/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente show(@PathVariable Long id) {
        return this.clientService.findById(id);
    }
    
    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente crear(@RequestBody Cliente cliente){
        //ojo se asigna fecha al cliente sobre la clase entidad mediante
        //un metodo de lifecycle (@PrePersist)
        return clientService.save(cliente);
    }
    
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable Long id){
        Cliente clientActual = clientService.findById(id);
       if (!(clientActual==null)){
           clientActual.setApellido(cliente.getApellido());
           clientActual.setEmail(cliente.getEmail());
           clientActual.setNombre(cliente.getNombre());

           return ResponseEntity.ok(clientService.save(clientActual));
       }else{
           return ResponseEntity.notFound().build();
       }

    }
    
    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clientService.delete(id);
    }
    
}
