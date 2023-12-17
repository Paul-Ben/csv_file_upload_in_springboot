package com.app.upload.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.upload.entities.Car;
import com.app.upload.repositories.CarRepository;
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void saveAll(List<Car> cars) {
        carRepository.saveAll(cars);
    }

    @Override
    public void saveFromCsv(MultipartFile file) throws IOException {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            // Assuming the first line is the header, skip it
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Car car = new Car(
                        // Parse the id, if present, otherwise set to null
                        fields[0].isEmpty() ? null : Long.parseLong(fields[0]),
                        fields[1],
                        fields[2],
                        Integer.parseInt(fields[3]),
                        fields[4]
                );
                cars.add(car);
            }
        }

        saveAll(cars);
    }
}
