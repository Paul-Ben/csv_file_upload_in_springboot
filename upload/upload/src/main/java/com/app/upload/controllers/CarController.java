package com.app.upload.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.upload.services.CarService;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/upload-form")
    public String showUpload(){

        return "/app/upload";
    }

    @PostMapping("/upload")
    public String uploadEntities(@RequestParam("file") MultipartFile file) throws IOException {
        carService.saveFromCsv(file);
        return "/app/upload";   
     }
}
