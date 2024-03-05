package com.example.friche.SpringWeb.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.friche.SpringWeb.models.Administrador;

public interface AdministradoresRepo extends CrudRepository<Administrador, Integer>{
    @Query(value= "select CASE WHEN count(1)>0 THEN 'true' ELSE 'false' END from administradores where id = :id", nativeQuery = true)
    public boolean exist(int id);
}