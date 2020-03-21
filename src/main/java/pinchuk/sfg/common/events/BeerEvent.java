package pinchuk.sfg.common.events;

import lombok.*;
import pinchuk.sfg.msccbeerservice.web.model.BeerDto;

import java.io.Serializable;

/**
 * @author Pinchuk Yevhen
 * @created 20/03/2020 - 21:21
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -1238342276322191396L;
    private BeerDto beerDto;

}
