package com.dular.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

/**
 * Created by maiquelknechtel on 10/07/24.
 */
@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String model;
    private String serial;
    private double price;
    private String brand;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Client client;
    private Date entryDate;
    private Date departureDate;
    private String description;
    private Date entryEquipmentWarranty;
    private Date departureEquipmentWarranty;
    private Double costValue;
    private String defectDefectForRepair;
    private boolean autorizado;
    private boolean pronto;
    private String obs;
    private Boolean entregue;
    private boolean devolucao;
    private boolean garantia;
    public Equipment(Client client) {
        this.client = client;
    }

    public Equipment() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getEntryEquipmentWarranty() {
        return entryEquipmentWarranty;
    }

    public void setEntryEquipmentWarranty(Date entryEquipmentWarranty) {
        this.entryEquipmentWarranty = entryEquipmentWarranty;
    }

    public Date getDepartureEquipmentWarranty() {
        return departureEquipmentWarranty;
    }

    public void setDepartureEquipmentWarranty(Date departureEquipmentWarranty) {
        this.departureEquipmentWarranty = departureEquipmentWarranty;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getCostValue() {
        return costValue;
    }

    public void setCostValue(Double costValue) {
        this.costValue = costValue;
    }

    public String getDefectForRepair() {
        return defectDefectForRepair;
    }

    public void setDefectForRepair(String defectDefectForRepair) {
        this.defectDefectForRepair = defectDefectForRepair;
    }

    public String getDefectDefectForRepair() {
        return defectDefectForRepair;
    }

    public void setDefectDefectForRepair(String defectDefectForRepair) {
        this.defectDefectForRepair = defectDefectForRepair;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    public boolean isPronto() {
        return pronto;
    }

    public void setPronto(boolean pronto) {
        this.pronto = pronto;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isDevolucao() {
        return devolucao;
    }

    public void setDevolucao(boolean devolucao) {
        this.devolucao = devolucao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(Boolean entergue) {
        this.entregue = entergue;
    }

    public boolean isGarantia() {
        return garantia;
    }

    public void setGarantia(boolean garantia) {
        this.garantia = garantia;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
