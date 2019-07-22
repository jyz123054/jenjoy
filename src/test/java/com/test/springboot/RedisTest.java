/*
 * package com.test.springboot;
 * 
 * import javax.annotation.Resource;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.data.redis.core.RedisTemplate; import
 * org.springframework.data.redis.core.ValueOperations; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * @SpringBootTest(classes = {App.class})
 * 
 * @RunWith(SpringRunner.class) public class RedisTest {
 * 
 * @Resource private RedisTemplate<String, String> redisTemplate;
 * 
 * @Test public void testRedis() { ValueOperations<String, String> ops =
 * redisTemplate.opsForValue(); ops.set("name", "enjoy"); String value =
 * ops.get("name"); System.out.println(value); String value2 = ops.get("jyz");
 * System.out.println(value2); }
 * 
 * }
 */