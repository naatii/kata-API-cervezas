package daw2a.kataapicervezas.service;

import daw2a.kataapicervezas.entities.Brewery;
import daw2a.kataapicervezas.repositories.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BreweryService {

    @Autowired
    private final BreweryRepository breweryRepository;
    public BreweryService(BreweryRepository breweryRepository) {
        this.breweryRepository = breweryRepository;
    }

    // Listar todas las cervecerías
    public List<Brewery> listarCervecerias() {
        return breweryRepository.findAll();
    }

    // Listar cervecería por id
    public Optional<Brewery> listarCerveceriaPorId(Long id) {
        return breweryRepository.findById(id);
    }

    // Borrar cervecería
    public void borrarCerveceria(Long id) {
        if (breweryRepository.existsById(id)) {
            breweryRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Cervecería no encontrada");
        }
    }

    // Actualizar cervecería
    public Brewery actualizarCerveceria(Long id, Brewery breweryActualizada) {
        return breweryRepository.findById(id).map(brewery -> {
            Optional.ofNullable(breweryActualizada.getName()).ifPresent(brewery::setName);
            Optional.ofNullable(breweryActualizada.getAddress1()).ifPresent(brewery::setAddress1);
            Optional.ofNullable(breweryActualizada.getAddress2()).ifPresent(brewery::setAddress2);
            Optional.ofNullable(breweryActualizada.getCity()).ifPresent(brewery::setCity);
            Optional.ofNullable(breweryActualizada.getState()).ifPresent(brewery::setState);
            Optional.ofNullable(breweryActualizada.getCode()).ifPresent(brewery::setCode);
            Optional.ofNullable(breweryActualizada.getCountry()).ifPresent(brewery::setCountry);
            Optional.ofNullable(breweryActualizada.getPhone()).ifPresent(brewery::setPhone);
            Optional.ofNullable(breweryActualizada.getWebsite()).ifPresent(brewery::setWebsite);
            Optional.of(breweryActualizada.getFilepath()).ifPresent(brewery::setFilepath);
            Optional.ofNullable(breweryActualizada.getDescription()).ifPresent(brewery::setDescription);
            Optional.of(breweryActualizada.getAddUser()).ifPresent(brewery::setAddUser);
            Optional.ofNullable(breweryActualizada.getLastMod()).ifPresent(brewery::setLastMod);

            return breweryRepository.save(brewery);
        }).orElseThrow(() -> new NoSuchElementException("Cervecería no encontrada con id " + id));
    }

    // Agregar cervecería
    public Brewery agregarCerveceria(Brewery brewery) {
        return breweryRepository.save(brewery);
    }


}
