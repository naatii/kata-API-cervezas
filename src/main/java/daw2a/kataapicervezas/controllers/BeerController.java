package daw2a.kataapicervezas.controllers;

import daw2a.kataapicervezas.entities.Beer;
import daw2a.kataapicervezas.service.BeerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/beer")
public class BeerController {

    @Autowired
    private final BeerService beerService;
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping
    public ResponseEntity<List<Beer>> listarCervezas() {
        List<Beer> beers = beerService.listarCervezas();
        return ResponseEntity.ok(beers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Beer> obtenerCerveza(Long id){
        try {
            Beer beer = beerService.obtenerCerveza(id)
                    .orElseThrow(()-> new NoSuchElementException("Categoria no encontrada con id " + id));
            return ResponseEntity.ok(beer);
        } catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PostMapping
    public ResponseEntity<Beer> agregarCerveza(@RequestBody @Valid Beer beer) {
        Beer nuevaBeer = beerService.agregarCerveza(beer);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaBeer);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Beer> borrarCerveza(Long id) {
        try {
            beerService.borrarCerveza(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Beer> actualizarCerveza(@PathVariable Long id, @RequestBody @Valid Beer beer) {
        try {
            Beer beerActualizada = beerService.actualizarCervaza(id, beer);
            return ResponseEntity.ok(beerActualizada);
        } catch (NoSuchElementException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}