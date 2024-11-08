package daw2a.kataapicervezas.service;

import daw2a.kataapicervezas.repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StyleService {
    @Autowired
    private final StyleRepository styleRepository;
    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }
}
