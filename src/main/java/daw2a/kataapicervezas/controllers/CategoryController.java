package daw2a.kataapicervezas.controllers;

import daw2a.kataapicervezas.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listarCategorias() {
        return "Categoria gerada";
    }
    @GetMapping
    public String obtenerCategoria(){
        return "Categoria";
    }
    @PostMapping
    public String agregarCategoria() {
        return "Categoria gerada";
    }
    @DeleteMapping
    public String borrarCategoria() {
        return "Categoria gerada";
    }
    @PutMapping
    public String actualizarCategoria() {
        return "Categoria gerada";
    }
}
