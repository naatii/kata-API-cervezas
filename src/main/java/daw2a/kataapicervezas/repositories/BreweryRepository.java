package daw2a.kataapicervezas.repositories;

import daw2a.kataapicervezas.entities.Brewery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreweryRepository extends CrudRepository<Brewery, Long> {
}
