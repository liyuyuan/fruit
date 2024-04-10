package afternow.cn.test;

import redis.clients.jedis.Jedis;

public class TestMain {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		jedis.auth("123456");
		jedis.ping();
		System.out.println(jedis.ping());
		System.out.println(jedis.getSet("a","lll"));
	}
}
