package com.mprs.aio.common.cache.redis;


import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;


/**
 * redis 缓存配置
 * @author Cary
 * @date 2018年8月10日
 */
@Configuration
@EnableCaching
public class RedisConfig {

	@Bean
    public KeyGenerator KeyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
    }
	
	@Bean
	CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
	    //user信息缓存配置
	    RedisCacheConfiguration userCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(30)).disableCachingNullValues().prefixKeysWith("user");
	    //product信息缓存配置
	    RedisCacheConfiguration productCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10)).disableCachingNullValues().prefixKeysWith("product");
	    Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
	    redisCacheConfigurationMap.put("user", userCacheConfiguration);
	    redisCacheConfigurationMap.put("product", productCacheConfiguration);
	    //初始化一个RedisCacheWriter
	    RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);


	    //设置CacheManager的值序列化方式为JdkSerializationRedisSerializer,但其实RedisCacheConfiguration默认就是使用StringRedisSerializer序列化key，JdkSerializationRedisSerializer序列化value,所以以下注释代码为默认实现
	    //ClassLoader loader = this.getClass().getClassLoader();
	    //JdkSerializationRedisSerializer jdkSerializer = new JdkSerializationRedisSerializer(loader);
	    //RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(jdkSerializer);
	    //RedisCacheConfiguration defaultCacheConfig=RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);


	    RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
	    //设置默认超过期时间是30秒
	    defaultCacheConfig.entryTtl(Duration.ofSeconds(30));
	    //初始化RedisCacheManager
	    RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, defaultCacheConfig, redisCacheConfigurationMap);
	    return cacheManager;
	}
}
