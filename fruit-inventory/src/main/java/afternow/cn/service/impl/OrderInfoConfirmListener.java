package afternow.cn.service.impl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;

@Service
public class OrderInfoConfirmListener implements ChannelAwareMessageListener, ConfirmCallback, ReturnCallback {
	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		try {
			System.out.println("consumer--:" + message.getMessageProperties() + ":" + new String(message.getBody()));
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		} catch (Exception e) {
			e.printStackTrace();// TODO 业务处理
			channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
		}
	}

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println("confirm--:correlationData:" + correlationData + ",ack:" + ack + ",cause:" + cause);
	}

	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		System.out.println("return--message:" + new String(message.getBody()) + ",replyCode:" + replyCode
				+ ",replyText:" + replyText + ",exchange:" + exchange + ",routingKey:" + routingKey);
	}

}
