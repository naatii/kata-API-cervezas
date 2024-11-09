package daw2a.kataapicervezas.controllers;

import daw2a.kataapicervezas.entities.Style;
import daw2a.kataapicervezas.service.StyleService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StyleControllerTest {

    @Mock
    private StyleService styleService;

    @InjectMocks
    private StyleController styleController;

    private Style style;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        style = new Style(
                1L,                     // id (Long)
                1,                     // categoryId (int)
                "Estilo Aleatorio",    // styleName (String)
                LocalDateTime.now()     // lastMod (LocalDateTime) - última modificación
        );
    }

    @Test
    void listarStyle() {
        // Arrange
        when(styleService.listarStyle()).thenReturn(Collections.singletonList(style));

        // Act
        ResponseEntity<List<Style>> response = styleController.listarStyles();

        // Assert
        assertEquals(1, Objects.requireNonNull(response.getBody()).size());
        assertEquals(style, response.getBody().get(0));
        verify(styleService, times(1)).listarStyle();
    }

    @Test
    void obtenerStyle() {
        // Arrange
        when(styleService.obtenerStyle(1L)).thenReturn(java.util.Optional.of(style));

        // Act
        ResponseEntity<Style> response = styleController.obtenerStyle(1L);

        // Assert
        assertEquals(style, response.getBody());
        verify(styleService, times(1)).obtenerStyle(1L);
    }

    @Test
    void agregarStyle() {
        // Arrange
        when(styleService.agregarStyle(style)).thenReturn(style);

        // Act
        ResponseEntity<Style> response = styleController.agregarStyle(style);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(style, response.getBody());
        verify(styleService, times(1)).agregarStyle(style);
    }

    @Test
    void borrarStyle() {
        // Arrange
        doNothing().when(styleService).borrarStyle(1L);

        // Act
        ResponseEntity<Style> response = styleController.borrarStyle(1L);

        // Assert
        assertEquals(204, response.getStatusCode().value());
        verify(styleService, times(1)).borrarStyle(1L);
    }

    @Test
    void actualizarStyle() {
        // Arrange
        when(styleService.actualizarStyle(1L, style)).thenReturn(style);

        // Act
        ResponseEntity<Style> response = styleController.actualizarStyle(1L, style);

        // Assert
        assertEquals(style, response.getBody());
        verify(styleService, times(1)).actualizarStyle(1L, style);
    }


}
