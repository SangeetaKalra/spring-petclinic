package co.learning.springpetclinicdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableSwagger2
public class PetClinicApp {

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApp.class, args);
    }
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("co.learning.springpetclinicdemo"))
//                .paths(PathSelectors.ant("/owners/*"))
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Petclinic API Application")
//                .description("Petclinic Documentation")
//                .version("1.0.0")
//                .contact(new Contact("Sangeeta", "http://localhost:8086/owners", "k.s@gmail.com"))
//                .build();
//    }

}
