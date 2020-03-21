package pinchuk.sfg.msccbeerservice.services.inventory;

import java.util.UUID;

/**
 * @author Pinchuk Yevhen
 * @created 18/03/2020 - 16:02
 */
public interface BeerInventoryService {

    Integer getOnhandInventory(UUID beerId);
}
