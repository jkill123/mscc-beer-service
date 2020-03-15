package com.pinchuk.yevhen.msccbeerservice.services;

import com.pinchuk.yevhen.msccbeerservice.web.model.BeerDto;
import com.pinchuk.yevhen.msccbeerservice.web.model.BeerPagedList;
import com.pinchuk.yevhen.msccbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

/**
 * Created by jt on 2019-06-06.
 */
public interface BeerService {
    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerDto getByUpc(String upc);
}
