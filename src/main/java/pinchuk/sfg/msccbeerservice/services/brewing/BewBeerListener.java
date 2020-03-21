package pinchuk.sfg.msccbeerservice.services.brewing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pinchuk.sfg.msccbeerservice.config.JmsConfig;
import pinchuk.sfg.msccbeerservice.domain.Beer;
import pinchuk.sfg.common.events.BrewBeerEvent;
import pinchuk.sfg.common.events.NewInventoryEvent;
import pinchuk.sfg.msccbeerservice.repositories.BeerRepository;
import pinchuk.sfg.msccbeerservice.web.model.BeerDto;

/**
 * @author Pinchuk Yevhen
 * @created 21/03/2020 - 11:32
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event){
        BeerDto beerDto = event.getBeerDto();
        Beer beer = beerRepository.getOne(beerDto.getId());
        beerDto.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);

        log.debug("Brewed beer :" + beer.getMinOnHand() + " : QOH: " + beerDto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }
}
