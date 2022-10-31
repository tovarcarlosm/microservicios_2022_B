package co.edu.eam.negocio.servicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServicioServicioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioServicioApplication.class, args);
    }

}
