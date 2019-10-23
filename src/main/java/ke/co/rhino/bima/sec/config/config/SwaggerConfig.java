package ke.co.rhino.bima.sec.config.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    private static final String BASE_RESOURCES_PACKAGE = "ke.co.rhino";

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_RESOURCES_PACKAGE)).build()
                .apiInfo(apiInfo())
                .forCodeGeneration(true);
    }

    private ApiInfo apiInfo() {
        ApiInfoBuilder builder = new ApiInfoBuilder();
        return builder
                .title("Rhino Infotech")
                .description("Security Server")
                .version("1.0")
                .contact(this.getContact()).build();
    }

    private Contact getContact() {
        return new Contact("Rhino Infotech", "https://www.rhino-infotech.co.ke", "info@rhino-infotech.co.ke");
    }
}
