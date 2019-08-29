package com.example.RestWithSpringBoot.repository;

import com.example.RestWithSpringBoot.model.Package;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Repository
public class PackageRepository {

    // Our in-memory database
    private static List<Package> pkgList = new ArrayList<>();

    private static int pkgCount = 4;

    // Seeding fictitious data for our database
    static {
        pkgList.add(new Package(1, "TELNET", new Date(), "IBM", "Apache"));
        pkgList.add(new Package(2, "TCP", new Date(), "Cisco", "MIT"));
        pkgList.add(new Package(3, "BROWSER", new Date(), "Google", "Apache"));
        pkgList.add(new Package(4, "WINDOWS", new Date(), "Microsoft", "MIT"));
    }

    // Lists all Packages
    public List<Package> findAll() {
        return pkgList;
    }

    // Save/create a new package
    public Package save(Package pkg) {
        if(pkg.getId()==null){
            pkg.setId(++pkgCount);
        }
        pkgList.add(pkg);
        return pkg;
    }

    // This finds a package by the id
    public Package findById(int id) {
       for(Package pkg : pkgList) {
           if(pkg.getId() == id){
               return pkg;
           }
       }
       return null;
    }

    // We can delete a package by id
    public Package deleteById(int id) {
        Iterator<Package> iterator = pkgList.iterator();
        while(iterator.hasNext()) {
            Package pkg = iterator.next();
            if(pkg.getId() == id) {
                iterator.remove();
                return pkg;
            }
        }
        return null;
    }
}
