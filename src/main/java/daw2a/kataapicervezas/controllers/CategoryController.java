package daw2a.kataapicervezas.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @GetMapping
    public String getCategoria() {
        return "Categoria gerada";
    }
    @PostMapping
    public String postCategoria() {
        return "Categoria gerada";
    }
    @DeleteMapping
    public String deleteCategoria() {
        return "Categoria gerada";
    }
    @PutMapping
    public String putCategoria() {
        return "Categoria gerada";
    }
}
