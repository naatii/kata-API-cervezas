package daw2a.kataapicervezas.service;

import daw2a.kataapicervezas.entities.Style;
import daw2a.kataapicervezas.repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StyleService {
    @Autowired
    private final StyleRepository styleRepository;
    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }
    public List<Style> listarStyle(){
        return styleRepository.findAll();
    }
    public Optional<Style> obtenerStyle(Long id){
        return styleRepository.findById(id);
    }
    public Style agregarStyle(Style style){
        return styleRepository.save(style);
    }
    public void borrarStyle(Long id){
        if(styleRepository.existsById(id)){
            throw new NoSuchElementException("Categoria no encontrada con id: " + id);
        }
        styleRepository.deleteById(id);
    }
    public Style actualizarStyle(Long id, Style styleActualizado){
        return styleRepository.findById(id).map(style->{
            Optional.ofNullable(styleActualizado.getStyleName()).ifPresent(style::setStyleName);
            Optional.ofNullable(styleActualizado.getLastMod()).ifPresent(style::setLastMod);
            return styleRepository.save(style);
        }).orElseThrow(()-> new NoSuchElementException("Style no encontrado con id: " + id));
    }
}