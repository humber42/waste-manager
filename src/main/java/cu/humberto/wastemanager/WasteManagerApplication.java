package cu.humberto.wastemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing
@EnableJpaRepositories
public class WasteManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WasteManagerApplication.class, args);
    }

}
