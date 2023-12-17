package com.app.upload.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.upload.entities.Car;

public interface CarRepository extends JpaRepository<Car,Long> {
    
}
