package pinchuk.sfg.common.events;

import lombok.NoArgsConstructor;
import pinchuk.sfg.msccbeerservice.web.model.BeerDto;

/**
 * @author Pinchuk Yevhen
 * @created 20/03/2020 - 21:24
 */
@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {
    
    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
