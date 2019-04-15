package afternow.cn.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import afternow.cn.entity.Goods;
import afternow.cn.service.GoodOutputSource;
import afternow.cn.service.GoodsService;

@RestController
@RequestMapping("/api/vi/goods")
@EnableBinding(GoodOutputSource.class)
public class GoodController {
	@Autowired
	private RestTemplate restTemplate;
	@Resource
	private DiscoveryClient client;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	@Output(GoodOutputSource.GOODSCHANNEL)
	private MessageChannel messageChannel;

	@ResponseBody
	@GetMapping("/list")
	public ResponseEntity<List<Goods>> list() {
		List<Goods> list = goodsService.goodsList();
		return new ResponseEntity<List<Goods>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public CompletableFuture<Goods> findById(@PathVariable Long id) {
		// CompletableFuture 非阻塞异步编程方法
		return goodsService.findById(id).thenApply(goods -> goods);
	}

	@PutMapping("/")
	public CompletableFuture<String> update(@RequestBody Goods goods) {
		// CompletableFuture 非阻塞异步编程方法
		// 已看到166
		return CompletableFuture.supplyAsync(() -> {
			goodsService.update(goods);
			// 发送消息，通知订单修改
			messageChannel.send(MessageBuilder.withPayload(goods).build());
			return goods.getGoodsId().toString();
		});
	}

}
