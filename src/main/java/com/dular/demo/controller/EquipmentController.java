package com.dular.demo.controller;

import com.dular.demo.DTO.EquipmentDto;
import com.dular.demo.domain.Equipment;
import com.dular.demo.service.ClientService;
import com.dular.demo.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by maiquelknechtel on 13/07/24.
 */
@RestController
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private ClientService clientService;

    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @PostMapping(value = "equipment-create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Equipment create(@RequestBody EquipmentDto equipmentDto){
        Equipment equipment = equipmentDto.toBuild(equipmentDto);
        if(equipmentDto.getIdClient()!=null)
            equipment.setClient(clientService.findById(equipmentDto.getIdClient()));
        equipment.setEntryDate(new Date());
        return equipmentService.create(equipment);
    }

    @RequestMapping(value = "equipment-findAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Equipment> findAll(){
        return equipmentService.findAll();
    }

    @RequestMapping(value = "equipment-update", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Equipment update(@RequestBody EquipmentDto equipmentDto){
        return equipmentService.update(equipmentDto.toBuildUpdate(equipmentDto));
    }
    @PostMapping(value = "equipment-delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody EquipmentDto equipmentDto){
        equipmentService.delete(equipmentDto.toBuild(equipmentDto));
    }

        @PostMapping(value = "equipment-findById", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Equipment findById(@RequestBody EquipmentDto equipmentDto){
        return equipmentService.findById(equipmentDto.getId());
    }
}
