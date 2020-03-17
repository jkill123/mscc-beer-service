package com.pinchuk.yevhen.msccbeerservice.services;

import com.pinchuk.yevhen.msccbeerservice.web.model.BeerDto;

import java.util.UUID;

/**
 * @author Pinchuk Yevhen
 * @created 17/03/2020 - 20:29
 */
public interface BeerService {
    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
