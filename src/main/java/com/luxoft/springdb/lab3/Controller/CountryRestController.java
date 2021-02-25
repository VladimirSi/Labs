package com.luxoft.springdb.lab3.Controller;


import com.luxoft.springdb.lab3.dao.CountryDao;
import com.luxoft.springdb.lab3.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CountryRestController {

    @Autowired
    CountryDao countryDao;


    @GetMapping("country")
    public ResponseEntity<List<Country>> getCountry() {
       return ResponseEntity.ok(countryDao.getCountryList());
    }

    @PostMapping("country")
    public String   createCountry(@RequestBody String codeName, String newCountryName) {
        countryDao.createCountry(codeName, newCountryName);
        return "Country created";
    }


    @PutMapping("country")
    public String   createCompany(@RequestBody String codeName, String newCountryName) {
        countryDao.updateCountryName(codeName, newCountryName);
        return "Country updated";
    }

    @DeleteMapping("country")
    public String deleteCompany(@RequestParam("codeName") String codeName) {
        countryDao.deleteCountry(codeName);
        return "Country deleted";
    }
}
