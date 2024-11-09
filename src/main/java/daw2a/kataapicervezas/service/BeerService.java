package daw2a.kataapicervezas.service;

import daw2a.kataapicervezas.entities.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import daw2a.kataapicervezas.repositories.BeerRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BeerService {

    @Autowired
    private final BeerRepository beerRepository;
    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    // Listar todas las cervezas
    public List<Beer> listarCervezas() {
        return beerRepository.findAll();
    }

    // Listar cerveza por id
    public Optional<Beer> obtenerCerveza(Long id) {
        return beerRepository.findById(id);
    }

    // Borrar cerveza
    public void borrarCerveza(Long id) {
        if (beerRepository.existsById(id)) {
            beerRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Cerveza no encontrada");
        }
    }

    // Actualizar cerveza
    public Beer actualizarCervaza(Long id, Beer beerActualizada) {
        return beerRepository.findById(id).map(beer -> {
            Optional.of(beerActualizada.getBreweryId()).ifPresent(beer::setBreweryId);
            Optional.ofNullable(beerActualizada.getName()).ifPresent(beer::setName);
            Optional.of(beerActualizada.getCategoryId()).ifPresent(beer::setCategoryId);
            Optional.of(beerActualizada.getStyleId()).ifPresent(beer::setStyleId);
            Optional.of(beerActualizada.getAbv()).ifPresent(beer::setAbv);
            Optional.of(beerActualizada.getIbu()).ifPresent(beer::setIbu);
            Optional.of(beerActualizada.getSrm()).ifPresent(beer::setSrm);
            Optional.of(beerActualizada.getUpc()).ifPresent(beer::setUpc);
            Optional.ofNullable(beerActualizada.getFilepath()).ifPresent(beer::setFilepath);
            Optional.ofNullable(beerActualizada.getDescription()).ifPresent(beer::setDescription);
            Optional.of(beerActualizada.getAddUser()).ifPresent(beer::setAddUser);
            Optional.ofNullable(beerActualizada.getLastMod()).ifPresent(beer::setLastMod);

            return beerRepository.save(beer);
        }).orElseThrow(() -> new NoSuchElementException("Libro no encontrado con id " + id));
    }

    // Agregar cerveza
    public Beer agregarCerveza(Beer beer) {
        return beerRepository.save(beer);
    }

}
