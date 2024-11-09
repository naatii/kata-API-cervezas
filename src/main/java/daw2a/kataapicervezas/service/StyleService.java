package daw2a.kataapicervezas.service;

import daw2a.kataapicervezas.entities.Style;
import daw2a.kataapicervezas.repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Optional<Style> obtenerStyle(int id){
        return styleRepository.findById(id);
    }
    public Style agregarStyle(Style style){
        if(!styleRepository.existsById()){}
    }
}