package daw2a.kataapicervezas.controllers;

import daw2a.kataapicervezas.entities.Category;
import daw2a.kataapicervezas.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    private Category category;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        category = new Category(
                1L,                     // id (Long)
                "Categoría Aleatoria",    // catName (String)
                LocalDateTime.now()     // lastMod (LocalDateTime) - última modificación
        );
    }

    @Test
    void listarCategory() {
        // Arrange
        when(categoryService.listarCategorias()).thenReturn(Collections.singletonList(category));

        // Act
        ResponseEntity<List<Category>> response = categoryController.listarCategorias();

        // Assert
        assertEquals(1, Objects.requireNonNull(response.getBody()).size());
        assertEquals(category, response.getBody().get(0));
        verify(categoryService, times(1)).listarCategorias();
    }

    @Test
    void obtenerCategory() {
        // Arrange
        when(categoryService.obtenerCategoria(1L)).thenReturn(java.util.Optional.of(category));

        // Act
        ResponseEntity<Category> response = categoryController.obtenerCategoria(1L);

        // Assert
        assertEquals(category, response.getBody());
        verify(categoryService, times(1)).obtenerCategoria(1L);
    }

    @Test
    void agregarCategory() {
        // Arrange
        when(categoryService.agregarCategoria(category)).thenReturn(category);

        // Act
        ResponseEntity<Category> response = categoryController.agregarCategoria(category);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(category, response.getBody());
        verify(categoryService, times(1)).agregarCategoria(category);
    }

    @Test
    void borrarCategory() {
        // Arrange
        doNothing().when(categoryService).borrarCategoria(1L);

        // Act
        ResponseEntity<Category> response = categoryController.borrarCategoria(1L);

        // Assert
        assertEquals(204, response.getStatusCode().value());
        verify(categoryService, times(1)).borrarCategoria(1L);
    }

    @Test
    void actualizarCategory() {
        // Arrange
        when(categoryService.actualizarCategoria(1L, category)).thenReturn(category);

        // Act
        ResponseEntity<Category> response = categoryController.actualizarCategoria(1L, category);

        // Assert
        assertEquals(category, response.getBody());
        verify(categoryService, times(1)).actualizarCategoria(1L, category);
    }

}
