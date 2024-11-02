package com.dular.demo.service;
import com.dular.demo.domain.Equipment;
import com.dular.demo.repository.EquipmentDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by maiquelknechtel on 13/07/24.
 */
@Service
public class EquipmentService {
    @Autowired
    private EquipmentDao equipmentDao;


    public Equipment create(Equipment equipment) {
        return equipmentDao.save(equipment);
    }

    public List<Equipment> findAll() {
        return (List<Equipment>) equipmentDao.findAll();
    }

    public Equipment findById(Integer id) {
        return equipmentDao.findById(id).orElse(null);
    }

    public Equipment update(Equipment equipment) {
        System.out.println("out id = "+equipment.getId());
        if (equipment.getId() == null) {
            System.out.println("out id = "+equipment.getId());
        }
        Equipment equipmentEdit = equipmentDao.findById(equipment.getId()).orElse(null);
        if (equipment.getBrand() != null)
            equipmentEdit.setBrand(equipment.getBrand());

        if (equipment.getModel() != null)
            equipmentEdit.setModel(equipment.getModel());

        if (equipment.getSerial() != null)
            equipmentEdit.setSerial(equipment.getSerial());

        if (equipment.getCostValue() != null)
            equipmentEdit.setCostValue(equipment.getCostValue());

        if (equipment.getDefectDefectForRepair() != null)
            equipmentEdit.setDefectDefectForRepair(equipment.getDefectDefectForRepair());
//
        if (equipment.isAutorizado())
            equipmentEdit.setAutorizado(equipment.isAutorizado());
        else
            equipmentEdit.setAutorizado(false);
        if (equipment.isPronto())
            equipmentEdit.setPronto(equipment.isPronto());
        else
            equipmentEdit.setPronto(false);

        if(equipment.getObs()!=null)
            equipmentEdit.setObs(equipment.getObs());
        equipmentEdit.setPrice(equipment.getPrice());

        if(equipment.isDevolucao())
            equipmentEdit.setDevolucao(true);
        else
            equipmentEdit.setDevolucao(false);

        if(equipment.getEntregue()!=null&&equipment.getEntregue()) {
            equipmentEdit.setEntregue(true);
            equipmentEdit.setDepartureDate(new Date());
        }else {
            equipmentEdit.setEntregue(false);
        }
        if(equipment.isGarantia()) {
            equipmentEdit.setGarantia(true);
            equipmentEdit.setEntryEquipmentWarranty(new Date());
        }
        if(equipment.getDepartureEquipmentWarranty()!=null){
            equipmentEdit.setDepartureEquipmentWarranty(equipment.getDepartureEquipmentWarranty());
        }
        if(equipment.getDescription()!=null)
            equipmentEdit.setDescription(equipment.getDescription());
        equipmentEdit.setEntregue(equipment.getEntregue());
        System.out.println("Entregue = "+equipment.getEntregue());
        return equipmentDao.save(equipmentEdit);
    }

    public void delete(Equipment equipment) {
        equipmentDao.delete(equipment);
    }


}
