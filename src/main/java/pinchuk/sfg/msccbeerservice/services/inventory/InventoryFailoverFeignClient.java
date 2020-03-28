package pinchuk.sfg.msccbeerservice.services.inventory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pinchuk.sfg.msccbeerservice.services.inventory.model.BeerInventoryDto;

import java.util.List;
import java.util.UUID;

/**
 * @author Pinchuk Yevhen
 * @created 28/03/2020 - 16:15
 */
@FeignClient("inventory-failover")
public interface InventoryFailoverFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/inventory-failover")
    ResponseEntity<List<BeerInventoryDto>> getOnhandInventory(UUID beerId);
}
