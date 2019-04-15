package afternow.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import zipkin2.server.internal.EnableZipkinServer;

/**
 * 日志分析平台搭建ELK elasticsearch、logstash、kibana
 * logstash主要是用来日志的搜集、过滤和分析的工具，kibana是一个为elasticsearch和logstash提供良好的数据分析、检索、汇总可视化Web界面的工具
 * 
 * @author liyuyuan_vendor
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableZipkinServer
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}

}
