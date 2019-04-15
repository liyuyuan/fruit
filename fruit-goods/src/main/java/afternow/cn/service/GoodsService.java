package afternow.cn.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import afternow.cn.entity.Goods;

public interface GoodsService {
	List<Goods> goodsList();
	CompletableFuture<Goods> findById(Long id);
	void update(Goods goods);
}
