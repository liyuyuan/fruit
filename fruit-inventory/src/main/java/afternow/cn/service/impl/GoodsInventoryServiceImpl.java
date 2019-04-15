package afternow.cn.service.impl;

import java.util.Map;

import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import afternow.cn.service.GoodsInventoryService;

@Service
@Transactional
public class GoodsInventoryServiceImpl implements GoodsInventoryService {
	@Override
	@ServiceActivator(inputChannel = Sink.INPUT)
	public void invenroty(Map<String, Object> msg) {
		System.out.println(msg.get("msg").toString() + ":" + msg.get("name"));
	}

}
