package com.dular.demo.repository;

/**
 * Created by maiquelknechtel on 10/07/24.
 */

import com.dular.demo.domain.Equipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentDao extends CrudRepository<Equipment, Integer> {
}