package daw2a.kataapicervezas.controllers;

import daw2a.kataapicervezas.entities.Category;
import daw2a.kataapicervezas.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> listarCategorias(){
        List<Category> categorias = categoryService.listarCategorias();
        return ResponseEntity.ok(categorias);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> obtenerCategoria(Long id){
        try {
            Category category = categoryService.obtenerCategoria(id)
                    .orElseThrow(()-> new NoSuchElementException("Categoria no encontrada con id " + id));
            return ResponseEntity.ok(category)
        } catch (NoSuchElementException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @PostMapping
    public String agregarCategoria(@RequestBody @Valid Category category) {
        Category nuevaCategory = categoryService.agregarCategoria(category);
        return ResponseEntity<Category>
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
