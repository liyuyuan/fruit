package afternow.cn.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 自定义负载均衡策略
 * @author liyuyuan_vendor
 *
 */
//@Configuration
//@RibbonClient(name = "fruit-goods", configuration = RibbonConfiguration.class)
public class RibbonConfiguration {
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}
}
