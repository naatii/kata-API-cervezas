package daw2a.kataapicervezas.service;

import daw2a.kataapicervezas.entities.Category;
import daw2a.kataapicervezas.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listarCategorias(){

        return categoryRepository.findAll();
    }

    public Optional<Category> obtenerCategoria(Long id) {
        return categoryRepository.findById(id);
    }

    public Category agregarCategoria(Category category) {
        return categoryRepository.save(category);
    }

    public void borrarCategoria(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new NoSuchElementException("Categoria no encontrada con id: " + id);
        }
    }

    public Category actualizarCategoria(Long id, Category categoryActualizada) {
        return categoryRepository.findById(id).map(category -> {
            Optional.ofNullable(categoryActualizada.getCatName()).ifPresent(category::setCatName);
            Optional.ofNullable(categoryActualizada.getLastMod()).ifPresent(category::setLastMod);
            return categoryRepository.save(category);
        }).orElseThrow(() -> new NoSuchElementException("Categoría no encontrada con id " + id));
    }


}
