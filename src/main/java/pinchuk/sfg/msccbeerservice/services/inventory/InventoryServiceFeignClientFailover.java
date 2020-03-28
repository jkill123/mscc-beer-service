package pinchuk.sfg.msccbeerservice.services.inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pinchuk.sfg.msccbeerservice.services.inventory.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;

/**
 * @author Pinchuk Yevhen
 * @created 28/03/2020 - 16:17
 */
@RequiredArgsConstructor
@Component
public class InventoryServiceFeignClientFailover implements InventoryServiceFeignClient{

    private final InventoryServiceFeignClientFailover feignClientFailover;
    @Override
    public ResponseEntity<List<BeerInventoryDto>> getOnhandInventory(UUID beerId) {
        return feignClientFailover.getOnhandInventory(beerId);
    }
}
