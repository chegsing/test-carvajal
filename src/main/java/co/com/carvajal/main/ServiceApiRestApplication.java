package co.com.carvajal.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * ServiceApiRestApplication
 * 
 * @author Charles Edinson Gomez
 * @since 04-02-2024
 * 
 */

@SpringBootApplication(scanBasePackages = { "co.com.carvajal",
                                            "co.com.carvajal.module" })
@EnableJpaRepositories(basePackages = { "co.com.carvajal.transversal.jpa.repository" })
@EntityScan(basePackages = { "co.com.carvajal.transversal.jpa.entity" })
public class ServiceApiRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApiRestApplication.class, args);
    }

}
