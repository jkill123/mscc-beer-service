package com.pinchuk.yevhen.msccbeerservice.web.mappers;

import com.pinchuk.yevhen.msccbeerservice.domain.Beer;
import com.pinchuk.yevhen.msccbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
