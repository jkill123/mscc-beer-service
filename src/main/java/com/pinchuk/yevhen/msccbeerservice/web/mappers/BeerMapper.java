package com.pinchuk.yevhen.msccbeerservice.web.mappers;

import com.pinchuk.yevhen.msccbeerservice.domain.Beer;
import com.pinchuk.yevhen.msccbeerservice.web.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    BeerDto beerToBeerDtoWithInventory(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}