package com.dular.demo.repository;

import com.dular.demo.domain.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by maiquelknechtel on 10/07/24.
 */

@Repository
public interface ClientDao extends CrudRepository<Client, Integer> {

    @Query("select c from Client c order by c.id desc")
    List<Client> findAllDesc();

    @Query("select c from Client c join fetch c.equipments eq where c.id =:idValue ")
        Client  findClientAndAllEquipment(@Param("idValue")Integer idValue);


}
