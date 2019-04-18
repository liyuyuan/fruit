package afternow.cn.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import afternow.cn.entity.OrderInfo;
import afternow.cn.mapper.OrderInfoMapper;
import afternow.cn.service.OrderInfoService;
import afternow.cn.utils.OrderNoUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@EnableBinding(Source.class)
@RabbitListener(queues = "orderInfoCreate")
public class OrderInfoServiceImpl implements OrderInfoService {
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	@Output(Source.OUTPUT)
	private MessageChannel messageChannel;
	@Autowired
	private AmqpTemplate amqpTemplate;
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void add() {
		// TODO Auto-generated method stub
		OrderInfo record = new OrderInfo();
		record.setUserId(1);
		record.setCity("上海市");
		record.setCountry("上海市");
		record.setGoodsAmount(100l);
		record.setOrderNo(OrderNoUtil.generOrderNo());
		orderInfoMapper.insert(record);
		// 发送消息
		messageChannel.send(MessageBuilder.withPayload(record).build());
		// 点对点发送
		amqpTemplate.convertAndSend("orderInfoCreate", record);
		for (int i = 0; i < 1000; i++) {
			String context = "hi, i am messages " + i;
			amqpTemplate.convertAndSend("OrderInfoMessages", "orderInfoCreate", context);
		}
		log.info("发送消息： " + MessageBuilder.withPayload(record).build().toString());
	}

	// @RabbitHandler
	// public synchronized void addOrderInfo(OrderInfo record) {
	// System.out.println(record);
	// }
	//
	// @Override
	// public void confirm(CorrelationData correlationData, boolean ack, String
	// cause) {
	// // TODO Auto-generated method stub
	// System.out.println("confirm: " + correlationData.getId() + ",s=" + cause +
	// ",b:" + ack);
	// }

}
