package com.bolsadeideas.springboot.backend.apirest.models.services;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.bolsadeideas.springboot.backend.apirest.models.dao.IClientDao;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author F.J. BOGA
 * 
 */
@Service
public class ClienteServiceImpl implements IClientService {

    @Autowired
    private IClientDao clientDao;

    @Override
    @Transactional
    //@org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clientDao.findAll();

    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clientDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(long id) {
        clientDao.deleteById(id);
        
    }

    @Override
    @Transactional
    public Cliente findById(Long id) {
        return clientDao.findById(id).orElse(null);
    }

}
