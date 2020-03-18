package pinchuk.msccbeerservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pinchuk.msccbeerservice.domain.Beer;
import pinchuk.msccbeerservice.web.model.BeerStyleEnum;

import java.util.UUID;

/**
 * @author Pinchuk Yevhen
 * @created 15/03/2020 - 19:011
 */
public interface BeerRepository extends JpaRepository<Beer, UUID> {
    Page<Beer> findAllByBeerName(String beerName, Pageable pageable);

    Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageable);

    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, Pageable pageable);

    Beer findByUpc(String upc);
}