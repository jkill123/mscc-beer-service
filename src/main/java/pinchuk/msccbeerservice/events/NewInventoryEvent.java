package pinchuk.msccbeerservice.events;

import pinchuk.msccbeerservice.web.model.BeerDto;

/**
 * @author Pinchuk Yevhen
 * @created 20/03/2020 - 21:24
 */
public class NewInventoryEvent extends BeerEvent {
    
    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
