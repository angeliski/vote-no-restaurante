package br.com.votenorestaurante;

import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import br.com.votenorestaurante.config.PostConfigurationManager;

@SpringBootApplication
@EnableSwagger2
public class Application extends SpringBootServletInitializer {

	@Autowired
	private PostConfigurationManager configurationManager;

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void runPostConfiguration() throws SQLException {
		configurationManager.runAllConfigurations();
	}

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("br.com.votenorestaurante.rests")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring REST Restaurant with Swagger")
				.description("Spring REST Restaurant with Swagger")
				.contact("Rogerio Angeliski").version("1.0").build();
	}

}
