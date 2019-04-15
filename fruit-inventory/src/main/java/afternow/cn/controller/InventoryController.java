package afternow.cn.controller;

import java.util.Map;

import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/vi/goods")
@Api("库存管理")
public class InventoryController {
	@ServiceActivator(inputChannel = Sink.INPUT)
	public void accept(Map<String, Object> msg) {
		System.out.println(msg.get("msg").toString() + ":" + msg.get("name"));
	}

}
