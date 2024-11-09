package daw2a.kataapicervezas.controllers;

import daw2a.kataapicervezas.entities.Style;
import daw2a.kataapicervezas.service.StyleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/style")
public class StyleController {
    private final StyleService styleService;

    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    @GetMapping
    public ResponseEntity<List<Style>> listarStyles() {
        List<Style> styles = styleService.listarStyle();
        return ResponseEntity.ok(styles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Style> obtenerStyle(@PathVariable Long id) {
        try {
            Style style = styleService.obtenerStyle(id)
                    .orElseThrow(() -> new NoSuchElementException("Style no encontrado con id: " + id));
            return ResponseEntity.ok(style);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Style> agregarStyle(@RequestBody @Valid Style style) {
        Style nuevoStyle = styleService.agregarStyle(style);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoStyle);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Style> borrarStyle(@PathVariable Long id) {
        try {
            styleService.borrarStyle(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Style> actualizarStyle(@PathVariable Long id,
                                                 @RequestBody @Valid Style styleActualizado) {
        try {
            Style style = styleService.actualizarStyle(id, styleActualizado);
            return ResponseEntity.ok(style);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}