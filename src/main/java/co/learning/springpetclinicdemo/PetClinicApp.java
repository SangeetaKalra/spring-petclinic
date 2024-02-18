package co.learning.springpetclinicdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
public class PetClinicApp {

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApp.class, args);
    }

}
