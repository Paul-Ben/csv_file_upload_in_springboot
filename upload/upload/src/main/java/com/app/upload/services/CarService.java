package com.app.upload.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.upload.entities.Car;

public interface CarService {
    List<Car> getAllCars();
    Car getCarById(Long id);
    Car saveCar(Car car);
    void deleteCar(Long id);
    void saveAll(List<Car> cars);
    void saveFromCsv(MultipartFile file) throws IOException;
}
