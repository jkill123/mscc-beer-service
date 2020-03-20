package pinchuk.msccbeerservice.events;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import pinchuk.msccbeerservice.web.model.BeerDto;

import java.io.Serializable;

/**
 * @author Pinchuk Yevhen
 * @created 20/03/2020 - 21:21
 */
@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -1238342276322191396L;
    private final BeerDto beerDto;


}
