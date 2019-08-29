package com.example.RestWithSpringBoot.controller;

import com.example.RestWithSpringBoot.model.Package;
import com.example.RestWithSpringBoot.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PackageController {

    @Autowired
    private PackageRepository packageRepository;

    @GetMapping("/packages")
    public List<Package> getAllPackages() {
       return packageRepository.findAll();
    }

    @GetMapping("/packages/{id}")
    public Package getPackage(@PathVariable int id) {
        return packageRepository.findById(id);
    }

    @PostMapping("/packages")
    public void createPackage(@RequestBody Package pkg) {
        packageRepository.save(pkg);
    }

    @DeleteMapping("/packages/{id}")
    public Package deletePackage(@PathVariable int id) {
        return packageRepository.deleteById(id);
    }
}
