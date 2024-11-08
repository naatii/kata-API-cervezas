package daw2a.kataapicervezas.controllers;

import jakarta.persistence.PostRemove;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/beer")
public class BeerController {
    @GetMapping
    public String getBeer() {
        return "Beer";
    }
    @PostMapping
    public String postBeer() {
        return "Beer";
    }
    @DeleteMapping
    public String deleteBeer() {
        return "Beer";
    }
    @PutMapping
    public String putBeer() {
        return "Beer";
    }
}
