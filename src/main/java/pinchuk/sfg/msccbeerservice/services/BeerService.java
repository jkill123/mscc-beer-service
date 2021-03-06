package pinchuk.sfg.msccbeerservice.services;

import org.springframework.data.domain.PageRequest;
import pinchuk.sfg.brewery.model.BeerDto;
import pinchuk.sfg.brewery.model.BeerPagedList;
import pinchuk.sfg.brewery.model.BeerStyleEnum;

import java.util.UUID;

/**
 * @author Pinchuk Yevhen
 * @created 17/03/2020 - 20:29
 */
public interface BeerService {
    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest of, Boolean showInventoryOnHand);

    BeerDto getByUpc(String upc);
}
