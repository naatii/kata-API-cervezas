package daw2a.kataapicervezas.controllers;

import daw2a.kataapicervezas.entities.Beer;
import daw2a.kataapicervezas.repositories.BeerRepository;
import daw2a.kataapicervezas.service.BeerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class BeerControllerTest {
    @Mock
    private BeerService beerService;

    @InjectMocks
    private BeerController beerController;

    private Beer beer;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        Beer beer = new Beer(
                1L,                     // id (Long)
                1,                      // breweryId (int)
                "Cerveza Aleatoria",    // name (String)
                1,                      // categoryId (int)
                1,                      // styleId (int)
                5.5f,                   // abv (float) - porcentaje de alcohol
                20.0f,                  // ibu (float) - índice de amargor
                10.0f,                  // srm (float) - índice de color
                123456789,              // upc (int) - código universal del producto
                "/path/to/image.jpg",   // filepath (String) - ruta de la imagen
                "Una deliciosa cerveza con un sabor único y refrescante.", // description (String)
                1,                      // addUser (int) - id del usuario que añadió la cerveza
                LocalDateTime.now()     // lastMod (LocalDateTime) - última modificación
        );
    }
    @Test
    void listarBeer() {
        // Arrange
        when(beerService.listarCervezas()).thenReturn(Collections.singletonList(beer));

        // Act
        ResponseEntity<List<Beer>> response = beerController.listarCervezas();

        // Assert
        assertEquals(1, response.getBody().size());
        assertEquals(beer, response.getBody().get(0));
        verify(beerService, times(1)).listarCervezas();
    }
}
