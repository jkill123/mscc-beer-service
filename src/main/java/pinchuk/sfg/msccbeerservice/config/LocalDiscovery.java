package pinchuk.sfg.msccbeerservice.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Pinchuk Yevhen
 * @created 28/03/2020 - 14:55
 */
@Profile("local-discovery")
@Configuration
@EnableDiscoveryClient
public class LocalDiscovery {
}
