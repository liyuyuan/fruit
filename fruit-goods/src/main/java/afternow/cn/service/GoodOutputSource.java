package afternow.cn.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface GoodOutputSource {
	String GOODSCHANNEL = "goodsChannel";
	
	@Output("goodsChannel")
	MessageChannel goodsOutput();

}
