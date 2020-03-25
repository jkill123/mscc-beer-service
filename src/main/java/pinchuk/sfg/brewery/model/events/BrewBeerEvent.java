package pinchuk.sfg.brewery.model.events;

import lombok.NoArgsConstructor;
import pinchuk.sfg.brewery.model.BeerDto;

/**
 * @author Pinchuk Yevhen
 * @created 20/03/2020 - 21:23
 */
@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
