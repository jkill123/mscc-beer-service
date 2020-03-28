package pinchuk.sfg.msccbeerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsccBeerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsccBeerServiceApplication.class, args);
    }

}
