package pinchuk.sfg.msccbeerservice.services.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pinchuk.sfg.brewery.model.BeerOrderDto;
import pinchuk.sfg.msccbeerservice.repositories.BeerRepository;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Pinchuk Yevhen
 * @created 26/03/2020 - 10:30
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class BeerOrderValidator {
    private final BeerRepository beerRepository;

    public Boolean validateOrder(BeerOrderDto beerOrderDto){
        AtomicInteger beersNotFound = new AtomicInteger();
        beerOrderDto.getBeerOrderLines().forEach(orderline->{
            if(beerRepository.findByUpc(orderline.getUpc()) == null){
                beersNotFound.incrementAndGet();
            }
        });

        return beersNotFound.get() == 0;
    }
}
