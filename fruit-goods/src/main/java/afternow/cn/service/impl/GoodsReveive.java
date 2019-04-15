package afternow.cn.service.impl;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;

import afternow.cn.entity.Goods;
import afternow.cn.service.GoodInputSource;
import afternow.cn.service.GoodsService;
import lombok.extern.slf4j.Slf4j;

/**
 * 消息监听服务 订阅消息
 * 
 * @author liyuyuan_vendor
 *
 */
@Slf4j
@EnableBinding(GoodInputSource.class)
public class GoodsReveive {
	@Autowired
	private GoodsService goodsService;

	@ServiceActivator(inputChannel = GoodInputSource.GOODSCHANNEL, outputChannel = GoodInputSource.REPLYCHANNEL)
	public CompletableFuture<String> accept(Goods goods) {
		return CompletableFuture.supplyAsync(() -> {
			log.info("接收到消息：" + goods);
			// 这里实现如果订单状态正确，库存相应减少
			return "true";
		});

	}
}
