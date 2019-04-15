package afternow.cn.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface GoodInputSource {
	String GOODSCHANNEL = "goodsChannel";
	String REPLYCHANNEL = "replychannel";

	@Input("goodsChannel")
	SubscribableChannel subscribableChannel();

	@Output("replychannel")
	MessageChannel replychannel();


}
