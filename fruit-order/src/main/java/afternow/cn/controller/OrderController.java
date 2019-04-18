package afternow.cn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

import afternow.cn.entity.Goods;
import afternow.cn.service.OrderInfoService;
import io.swagger.annotations.Api;

@Controller
@RequestMapping("/api/v1/order")
@Api(value = "Order Management")
public class OrderController {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private OrderInfoService orderInfoService;

	@PostMapping("/add")
	public ResponseEntity<String> add() {
		orderInfoService.add();
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/list")
	public ResponseEntity<List<Goods>> list() {
		String result = restTemplate.getForObject("http://fruit-goods/api/vi/goods/list", String.class);
		return new ResponseEntity<>(JSON.parseObject(result, List.class), HttpStatus.OK);
	}

}
