package afternow.cn.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import afternow.cn.entity.Goods;
import afternow.cn.entity.OrderInfo;
import afternow.cn.entity.example.GoodsExample;
import afternow.cn.exception.FruitException;
import afternow.cn.mapper.GoodsMapper;
import afternow.cn.service.GoodsService;
import afternow.cn.service.OrderService;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private OrderService orderService;
	@Autowired
	private DiscoveryClient discoveryClient;

	@HystrixCommand(fallbackMethod = "goodsListError", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "30"), @HystrixProperty(name = "maxQueueSize", value = "101"),
			@HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
			@HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
			@HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
			@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440") })
	@Override
	public List<Goods> goodsList() {
		try {
			// TODO Auto-generated method stub
			// 多个实力 负载均衡 uri 为实例完整url
			List<ServiceInstance> instances = discoveryClient.getInstances("serviceName");
			String serviceUri = "./";
			if (instances != null && instances.size() > 0) {
				Random random = new Random();
				ServiceInstance serviceInstance = instances.get(random.nextInt() - 1);
				serviceUri = serviceInstance.getUri().toString();
			}
			Gson gson = new Gson();

			CompletableFuture<Object> completableFuture = new CompletableFuture<Object>();
			GoodsExample goodsExample = new GoodsExample();
			goodsExample.createCriteria().andGoodsIdBetween(1, 1000);
			List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
			return goodsList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new FruitException("call dependency service fail.");
		}
	}

	public List<Goods> goodsListError() {
		List<Goods> goods = new ArrayList<>();
		goods.add(new Goods());
		return goods;
	}

	@Override
	public CompletableFuture<Goods> findById(Long id) {
		// TODO Auto-generated method stub
		return CompletableFuture.supplyAsync(() -> {
			return goodsMapper.selectByPrimaryKey(id.intValue());
		});
	}

	@Override
	public void update(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.updateByPrimaryKeySelective(goods);
	}

	@HystrixCommand(fallbackMethod = "")
	public OrderInfo findOrderInfoById(Long id) {
		OrderInfo orderInfo = orderService.findById(id);
		return orderInfo;
	}

	public OrderInfo findOrderInfoByIdFallBack() {
		return new OrderInfo();
	}

}
