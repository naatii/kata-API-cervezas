package daw2a.kataapicervezas.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brewery")
public class BreweryController {
    @GetMapping
    public String getBrewery() {
        return "Brewery";
    }
    @PostMapping
    public String postBrewery() {
        return "Brewery";
    }
    @DeleteMapping
    public String deleteBrewery() {
        return "Brewery";
    }
    @PutMapping
    public String putBrewery() {
        return "Brewery";
    }
}
