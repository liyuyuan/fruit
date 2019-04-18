package afternow.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import afternow.cn.service.impl.CallBackSender;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/vi/goods")
@Api("库存管理")
public class InventoryController {
	@Autowired
	private CallBackSender sender;

	@RequestMapping("/callback")
	public void callbak() {
		sender.send("topic.baqgl.admin.1", "测试消息");
	}

}
