package daw2a.kataapicervezas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import daw2a.kataapicervezas.repositories.BeerRepository;

@Service
public class BeerService {

    @Autowired
    private final BeerRepository beerRepository;
    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

}
