package daw2a.kataapicervezas.repositories;

import daw2a.kataapicervezas.entities.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Integer> {

}
