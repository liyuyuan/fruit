package afternow.cn.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import afternow.cn.entity.OrderInfo;

@FeignClient("fruit-order")
public interface OrderService {

	@GetMapping("/api/v1/order/{id}")
	OrderInfo findById(@PathVariable Long id);

	@PostMapping(value = "/api/v1/order", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	void add(@RequestBody OrderInfo orderInfo);

}
