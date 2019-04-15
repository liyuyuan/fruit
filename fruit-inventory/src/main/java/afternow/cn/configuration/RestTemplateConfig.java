package afternow.cn.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lyy on 2018/11/30.
 */
@Configuration
public class RestTemplateConfig {
	@Autowired
	private HttpMessageConverters fastJsonHttpMessageConverters;

	@Bean(name = "balancedRestTemplate")
	RestTemplate balancedRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(fastJsonHttpMessageConverters.getConverters());
		return restTemplate;
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(fastJsonHttpMessageConverters.getConverters());
		SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
		factory.setConnectTimeout(3000);
		factory.setReadTimeout(3000);
		return restTemplate;
	}
	

}
