package com.dular.demo.DTO;
import com.dular.demo.domain.Equipment;

import java.util.Date;

/**
 * Created by maiquelknechtel on 12/07/24.
 */
public class EquipmentDto {

    private Integer id;
    private String brand;
    private String model;
    private String serial;
    private Double costValue;
    private String defectForRepair;
    private Integer idClient;
    private Boolean pronto;
    private Boolean autorizado;
    private Boolean entregue;
    private Boolean garantia;
    private Boolean devolucao;
    private String obs;
    private String description;
    private Boolean departuretWarranty;

    private Double price;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Double getCostValue() {
        return costValue;
    }

    public void setCostValue(Double costValue) {
        this.costValue = costValue;
    }

    public String getDefectForRepair() {
        return defectForRepair;
    }

    public void setDefectForRepair(String defectForRepair) {
        this.defectForRepair = defectForRepair;
    }

    public Equipment toBuild(EquipmentDto equipmentDto) {
        Equipment entity = new Equipment();
        if (equipmentDto.getId() != null)
            entity.setId(equipmentDto.getId());
        entity.setDescription(description);
        entity.setModel(model);
        entity.setSerial(serial);
        entity.setBrand(brand);
        entity.setDevolucao(devolucao);
        entity.setObs(obs);
        entity.setPrice(price);

        return entity;
    }

    public Equipment toBuildUpdate(EquipmentDto equipmentDto) {
        Equipment entity = new Equipment();
        entity.setId(id);
        if (brand != null) {
            entity.setBrand(brand);
        }
        if (price != null) {
            entity.setPrice(price);
        }
        if (model != null) {
            entity.setModel(model);
        }
        if (serial != null) {
            entity.setSerial(serial);
        }
        if (costValue != null) {

        }
        if (defectForRepair != null) {
            entity.setDefectForRepair(defectForRepair);
        }


        if (pronto != null) {
            System.out.println("toBuild");
            System.out.println(pronto);
            entity.setPronto(pronto);
        }
        if (autorizado != null) {
            entity.setAutorizado(autorizado);
        }
        if (devolucao != null) {
            entity.setDevolucao(devolucao);
            System.out.println("devolucao entrei aqui ... = "+devolucao);
        }
        if (entregue!=null) {
            entity.setEntregue(entregue);
            entity.setDepartureDate(new Date());
        }
        if(garantia!=null){
            entity.setGarantia(garantia);
            //entity.setDepartureEquipmentWarranty(new Date());
        }
        if(departuretWarranty!=null&&departuretWarranty==true)
            entity.setDepartureEquipmentWarranty(new Date());

        entity.setDescription(description);

        entity.setObs(obs);

        return entity;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public boolean isPronto() {
        return pronto;
    }

    public void setPronto(boolean pronto) {
        this.pronto = pronto;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    public Boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(Boolean entregue) {
        this.entregue = entregue;
    }

    public Boolean getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Boolean devolucao) {
        this.devolucao = devolucao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getPronto() {
        return pronto;
    }

    public void setPronto(Boolean pronto) {
        this.pronto = pronto;
    }

    public Boolean getAutorizado() {
        return autorizado;
    }

    public void setAutorizado(Boolean autorizado) {
        this.autorizado = autorizado;
    }

    public Boolean getGarantia() {
        return garantia;
    }

    public void setGarantia(Boolean garantia) {
        this.garantia = garantia;
    }

    public Boolean getDeparturetWarranty() {
        return departuretWarranty;
    }

    public void setDeparturetWarranty(Boolean departuretWarranty) {
        this.departuretWarranty = departuretWarranty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

