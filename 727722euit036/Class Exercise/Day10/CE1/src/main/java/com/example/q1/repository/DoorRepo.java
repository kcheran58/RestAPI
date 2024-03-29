package com.example.springapp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.Door;

@Repository
public interface DoorRepo extends JpaRepository<Door,Integer> {
   


    
    List<Door>findByColor(String color);


    List<Door>findByDoorType(String doorType);

   
    List<Door>findByDoorId(int doorId);

   

   

    
}