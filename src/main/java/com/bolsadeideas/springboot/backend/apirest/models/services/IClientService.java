/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bolsadeideas.springboot.backend.apirest.models.services;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import java.util.List;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;

/**
 *
 * @author F.J. BOGA
 */
public interface IClientService {
    public List<Cliente> findAll();
    public Cliente save(Cliente cliente);
    public void delete(long id);
    public Cliente findById(Long id);
    
}
