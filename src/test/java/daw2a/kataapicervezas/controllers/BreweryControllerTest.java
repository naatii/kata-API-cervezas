package daw2a.kataapicervezas.controllers;

import daw2a.kataapicervezas.entities.Brewery;
import daw2a.kataapicervezas.service.BreweryService;
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

public class BreweryControllerTest {

    @Mock
    private BreweryService breweryService;

    @InjectMocks
    private BreweryController breweryController;

    private Brewery brewery;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        brewery = new Brewery(
                1,                     // id (int)
                "Cervecería Aleatoria",    // name (String)
                "Calle Aleatoria 123",                      // address1 (String)
                "Calle Aleatoria 456",                      // address2 (String)
                "Ciudad Aleatoria",    // city (String)
                "Estado Aleatorio",                      // state (String)
                "12345",                      // code (String)
                "País Aleatorio",    // country (String)
                "123456789",              // phone (String)
                "http://www.example.com",   // website (String)
                "/path/to/image.jpg",   // filepath (String)
                "Una deliciosa cerveza con un sabor único y refrescante.", // description (String)
                1,                      // addUser (int) - id del usuario que añadió la cerveza
                LocalDateTime.now()     // lastMod (LocalDateTime) - última modificación
        );
    }

    @Test
    void listarBrewery() {
        // Arrange
        when(breweryService.listarCervecerias()).thenReturn(Collections.singletonList(brewery));

        // Act
        ResponseEntity<List<Brewery>> response = breweryController.listarCervecerias();

        // Assert
        assertEquals(1, Objects.requireNonNull(response.getBody()).size());
        assertEquals(brewery, response.getBody().get(0));
        verify(breweryService, times(1)).listarCervecerias();
    }

    @Test
    void obtenerBrewery() {
        // Arrange
        when(breweryService.obtenerCerveceria(1L)).thenReturn(Optional.of(brewery));

        // Act
        ResponseEntity<Brewery> response = breweryController.obtenerCerveceria(1L);

        // Assert
        assertEquals(brewery, response.getBody());
        verify(breweryService, times(1)).obtenerCerveceria(1L);
    }

    @Test
    void agregarBrewery() {
        // Arrange
        when(breweryService.agregarCerveceria(brewery)).thenReturn(brewery);

        // Act
        ResponseEntity<Brewery> response = breweryController.agregarCerveceria(brewery);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(brewery, response.getBody());
        verify(breweryService, times(1)).agregarCerveceria(brewery);
    }

    @Test
    void borrarBrewery() {
        // Arrange
        doNothing().when(breweryService).borrarCerveceria(1L);

        // Act
        ResponseEntity<Brewery> response = breweryController.borrarCerveceria(1L);

        // Assert
        assertEquals(204, response.getStatusCode().value());
        verify(breweryService, times(1)).borrarCerveceria(1L);
    }

    @Test
    void actualizarBrewery() {
        // Arrange
        when(breweryService.actualizarCerveceria(1L, brewery)).thenReturn(brewery);

        // Act
        ResponseEntity<Brewery> response = breweryController.actualizarCerveceria(1L, brewery);

        // Assert
        assertEquals(brewery, response.getBody());
        verify(breweryService, times(1)).actualizarCerveceria(1L, brewery);
    }

}
