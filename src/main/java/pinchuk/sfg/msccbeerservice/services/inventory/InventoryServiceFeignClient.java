package pinchuk.sfg.msccbeerservice.services.inventory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pinchuk.sfg.msccbeerservice.services.inventory.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;

import static pinchuk.sfg.msccbeerservice.services.inventory.BeerInventoryServiceRestTemplateImpl.INVENTORY_PATH;

/**
 * @author Pinchuk Yevhen
 * @created 28/03/2020 - 15:27
 */
@FeignClient("inventory-service")
public interface InventoryServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = INVENTORY_PATH)
    ResponseEntity<List<BeerInventoryDto>> getOnhandInventory(UUID beerId);
}
