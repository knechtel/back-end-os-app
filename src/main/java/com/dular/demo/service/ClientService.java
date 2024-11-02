package com.dular.demo.service;

import com.dular.demo.domain.Client;
import com.dular.demo.repository.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maiquelknechtel on 10/07/24.
 */

@Service
public class ClientService {
    @Autowired
    private ClientDao clientDao;

    public Client create(Client client) {
        return clientDao.save(client);
    }

    public List<Client> FindAll() {
        return clientDao.findAllDesc();
    }

    public Client findById(Integer id) {
        return clientDao.findById(id).orElse(null);
    }

    public void update(Client client) {
        if (client.getId() == null) {
            return;
        }

        Client clientEdit = clientDao.findById(client.getId()).orElse(null);

        if (client.getCpf() != null)
            clientEdit.setCpf(client.getCpf());
        if (client.getEmail() != null)
            clientEdit.setEmail(client.getEmail());
        if (client.getName() != null)
            clientEdit.setName(client.getName());
        if(client.getAddress()!=null)
            clientEdit.setAddress(client.getAddress());
        if(client.getPhone()!=null)
            clientEdit.setPhone(client.getPhone());

        clientDao.save(clientEdit);
    }

    public void delete(Client client) {
        clientDao.delete(client);
    }

    public Client findById(Client client) {
        return clientDao.findById(client.getId()).orElse(null);
    }

    public Client findAllEquipment(Client client) {
        Client c = clientDao.findClientAndAllEquipment(client.getId());
        return c;
    }
}
