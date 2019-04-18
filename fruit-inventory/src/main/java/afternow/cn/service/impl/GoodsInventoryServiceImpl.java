package afternow.cn.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import afternow.cn.entity.OrderInfo;
import afternow.cn.service.GoodsInventoryService;

@EnableBinding(Sink.class)
@Transactional
@Service
public class GoodsInventoryServiceImpl implements GoodsInventoryService {
//	@StreamListener(Sink.INPUT)
//	public synchronized void invenroty(OrderInfo msg) {
//		// 消息处理
//		System.out.println("recerver:" + msg);
//	}
	
	@StreamListener(Sink.INPUT)
	public void process(String message) {
		System.out.println("Topic Receiver2  : " + message);
	}


}
