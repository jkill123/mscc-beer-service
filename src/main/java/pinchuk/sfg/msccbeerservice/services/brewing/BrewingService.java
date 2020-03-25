package pinchuk.sfg.msccbeerservice.services.brewing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pinchuk.sfg.msccbeerservice.config.JmsConfig;
import pinchuk.sfg.msccbeerservice.domain.Beer;
import pinchuk.sfg.brewery.model.events.BrewBeerEvent;
import pinchuk.sfg.msccbeerservice.repositories.BeerRepository;
import pinchuk.sfg.msccbeerservice.services.inventory.BeerInventoryService;
import pinchuk.sfg.msccbeerservice.web.mappers.BeerMapper;

import java.util.List;

/**
 * @author Pinchuk Yevhen
 * @created 20/03/2020 - 21:28
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BrewingService {

    private final BeerRepository beerRepository;
    private final BeerInventoryService beerInventoryService;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 5000)
    public void checkForLowInventory() {
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            Integer invQQH = beerInventoryService.getOnhandInventory(beer.getId());

            log.debug("Min on Hand is : " + beer.getMinOnHand());
            log.debug("Inventory is : " + invQQH);

            if (beer.getMinOnHand() >= invQQH) {
                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE, new BrewBeerEvent(beerMapper.beerToBeerDto(beer)));
            }
        });
    }
}
