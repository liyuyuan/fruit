package afternow.cn.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

import afternow.cn.entity.Goods;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/order")
@Api(value = "Order Management")
public class OrderController {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	@Output(Source.OUTPUT)
	private MessageChannel messageChannel;

	@SuppressWarnings("unchecked")
	@GetMapping("/list")
	public ResponseEntity<List<Goods>> list() {
		String result = restTemplate.getForObject("http://fruit-goods/api/vi/goods/list", String.class);
		return new ResponseEntity<>(JSON.parseObject(result, List.class), HttpStatus.OK);
	}

	@PostMapping("/send")
	public void write(@RequestBody Map<String, Object> msg) {
		messageChannel.send(MessageBuilder.withPayload(msg).build());
	}

}
