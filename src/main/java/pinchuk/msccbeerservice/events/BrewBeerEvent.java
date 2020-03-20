package pinchuk.msccbeerservice.events;

import pinchuk.msccbeerservice.web.model.BeerDto;

/**
 * @author Pinchuk Yevhen
 * @created 20/03/2020 - 21:23
 */
public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
