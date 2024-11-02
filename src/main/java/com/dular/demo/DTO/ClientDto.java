package com.dular.demo.DTO;

import com.dular.demo.domain.Client;

/**
 * Created by maiquelknechtel on 10/07/24.
 */

public class ClientDto {


    private Integer id;
    private String name;
    private String email;
    private String cpf;

    private String phone;

    private String address;

    public Client toBuild(ClientDto clientDto) {
        Client entity = new Client();
        if (id != null) {
            entity.setId(id);
        }
        if (name != null)
            entity.setName(name);
        if (email != null)
            entity.setEmail(email);
        if (cpf != null)
            entity.setCpf(cpf);
        if(phone!=null)
            entity.setPhone(phone);

        entity.setAddress(address);

        return entity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
