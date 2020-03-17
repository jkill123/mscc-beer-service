package com.pinchuk.yevhen.msccbeerservice.services;

import com.pinchuk.yevhen.msccbeerservice.domain.Beer;
import com.pinchuk.yevhen.msccbeerservice.repositories.BeerRepository;
import com.pinchuk.yevhen.msccbeerservice.web.controller.NotFoundException;
import com.pinchuk.yevhen.msccbeerservice.web.mappers.BeerMapper;
import com.pinchuk.yevhen.msccbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Pinchuk Yevhen
 * @created 17/03/2020 - 21:34
 */
@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {

        return beerMapper.beerToBeerDto(
                beerRepository.save(beerMapper.beerDtoToBeer(beerDto))
        );
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {

        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(String.valueOf(beerDto.getUpc()));

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
