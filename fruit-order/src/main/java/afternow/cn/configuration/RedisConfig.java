/*
 * package afternow.cn.configuration;
 * 
 * import org.springframework.beans.factory.annotation.Value; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.data.redis.connection.RedisConnectionFactory; import
 * org.springframework.data.redis.core.RedisTemplate; import
 * org.springframework.data.redis.core.StringRedisTemplate; import
 * org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer; import
 * org.springframework.data.redis.serializer.StringRedisSerializer;
 * 
 * import com.fasterxml.jackson.annotation.JsonAutoDetect; import
 * com.fasterxml.jackson.annotation.PropertyAccessor; import
 * com.fasterxml.jackson.databind.ObjectMapper;
 * 
 *//**
	 * redis 緩存配置类
	 * 
	 * @author 独孤行者
	 *
	 *//*
		 * @Configuration public class RedisConfig {
		 * 
		 * @Value("${spring.redis.host}") private String host;
		 * 
		 * @Value("${spring.redis.port}") private int port;
		 * 
		 * @Value("${spring.redis.timeout}") private int timeout;
		 * 
		 * // 自定义缓存key生成策略 // @Bean // public KeyGenerator keyGenerator() { // return
		 * new KeyGenerator(){ // @Override // public Object generate(Object target,
		 * java.lang.reflect.Method method, Object... params) { // StringBuffer sb = new
		 * StringBuffer(); // sb.append(target.getClass().getName()); //
		 * sb.append(method.getName()); // for(Object obj:params){ //
		 * sb.append(obj.toString()); // } // return sb.toString(); // } // }; // }
		 * 
		 * @Bean public RedisTemplate<String, String>
		 * redisTemplate(RedisConnectionFactory factory) { StringRedisTemplate template
		 * = new StringRedisTemplate(factory); setSerializer(template);// 设置序列化工具
		 * template.afterPropertiesSet(); return template; }
		 * 
		 * @Bean public RedisTemplate<String, Object>
		 * redisTemplateo(RedisConnectionFactory factory) { RedisTemplate<String,
		 * Object> template = new RedisTemplate<String, Object>();
		 * template.setConnectionFactory(factory); Jackson2JsonRedisSerializer
		 * jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		 * ObjectMapper om = new ObjectMapper(); om.setVisibility(PropertyAccessor.ALL,
		 * JsonAutoDetect.Visibility.ANY);
		 * om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		 * jackson2JsonRedisSerializer.setObjectMapper(om); StringRedisSerializer
		 * stringRedisSerializer = new StringRedisSerializer(); // key采用String的序列化方式
		 * template.setKeySerializer(stringRedisSerializer); // hash的key也采用String的序列化方式
		 * template.setHashKeySerializer(stringRedisSerializer); // value序列化方式采用jackson
		 * template.setValueSerializer(jackson2JsonRedisSerializer); //
		 * hash的value序列化方式采用jackson
		 * template.setHashValueSerializer(jackson2JsonRedisSerializer);
		 * template.afterPropertiesSet(); return template; }
		 * 
		 * private void setSerializer(StringRedisTemplate template) {
		 * 
		 * @SuppressWarnings({ "rawtypes", "unchecked" }) Jackson2JsonRedisSerializer
		 * jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		 * ObjectMapper om = new ObjectMapper(); om.setVisibility(PropertyAccessor.ALL,
		 * JsonAutoDetect.Visibility.ANY);
		 * om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		 * jackson2JsonRedisSerializer.setObjectMapper(om);
		 * template.setValueSerializer(jackson2JsonRedisSerializer); }
		 * 
		 * }
		 */