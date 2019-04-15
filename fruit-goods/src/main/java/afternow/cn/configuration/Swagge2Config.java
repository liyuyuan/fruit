package afternow.cn.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagge2Config {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).globalOperationParameters(setHeaderToken())
				.select().apis(RequestHandlerSelectors.basePackage("afternow.cn.controller")).paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("fruit-goods api").description("商品管理").version("1.0")
				.termsOfServiceUrl("http://www.github.com/kongchen/swagger-maven-plugin").build();
	}

	private List<Parameter> setHeaderToken() {
		ParameterBuilder builder = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<>();
		builder.name("accessToken").description("token").modelRef(new ModelRef("string")).parameterType("header")
				.required(false);
		pars.add(builder.build());
		return pars;
	}

}
