package daw2a.kataapicervezas.controllers;

import daw2a.kataapicervezas.entities.Brewery;
import daw2a.kataapicervezas.service.BreweryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/brewery")
public class BreweryController {

    private final BreweryService breweryService;

    public BreweryController(BreweryService breweryService) {
        this.breweryService = breweryService;
    }

    @GetMapping
    public ResponseEntity<List<Brewery>> listarCervecerias() {
        List<Brewery> breweries = breweryService.listarCervecerias();
        return ResponseEntity.ok(breweries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brewery> obtenerCerveceria(@PathVariable Long id) {
        try {
            Brewery brewery = breweryService.obtenerCerveceria(id)
                    .orElseThrow(() -> new NoSuchElementException("Cerveceria no encontrada con id " + id));
            return ResponseEntity.ok(brewery);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Brewery> agregarCerveceria(@RequestBody @Valid Brewery brewery) {
        Brewery nuevaBrewery = breweryService.agregarCerveceria(brewery);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaBrewery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Brewery> borrarCerveceria(@PathVariable Long id) {
        try {
            breweryService.borrarCerveceria(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brewery> actualizarCerveceria(@PathVariable Long id, @RequestBody @Valid Brewery brewery) {
        try {
            Brewery breweryActualizada = breweryService.actualizarCerveceria(id, brewery);
            return ResponseEntity.ok(breweryActualizada);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
