package pinchuk.sfg.msccbeerservice.services.order;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import pinchuk.sfg.brewery.model.events.ValidateOrderRequest;
import pinchuk.sfg.brewery.model.events.ValidateOrderResult;
import pinchuk.sfg.msccbeerservice.config.JmsConfig;

/**
 * @author Pinchuk Yevhen
 * @created 26/03/2020 - 10:29
 */
@RequiredArgsConstructor
@Component
public class BeerOrderValidationListener {

    private final BeerOrderValidator validator;
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_QUEUE)
    public void listen(ValidateOrderRequest validateOrderRequest){
        Boolean isValid = validator.validateOrder(validateOrderRequest.getBeerOrder());

        jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE,
                ValidateOrderResult.builder()
                    .isValid(isValid)
                    .orderId(validateOrderRequest.getBeerOrder().getId())
                    .build());
    }
}
