package afternow.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessageEndpoint;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableBinding(Sink.class)
@MessageEndpoint
@IntegrationComponentScan
@EnableSwagger2
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class GoodsInventoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(GoodsInventoryApplication.class, args);
	}
}
