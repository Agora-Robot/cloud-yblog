package com.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;

@SpringBootApplication
@EnableDiscoveryClient
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60*60*3) //开启springSession+redis解决分布式session问题
public class GatewayApplication3201 {
  private static RedisTemplate redisTemplate;

  @Autowired
  public void setRedisTemplate(RedisTemplate redisTemplate) {
    GatewayApplication3201.redisTemplate = redisTemplate;
  }

  public static void main(String[] args) throws FileNotFoundException {
    SpringApplication.run(GatewayApplication3201.class, args);

    String path = ResourceUtils.getURL("classpath:static").getPath();
    String staticPath = path.substring(1, path.length());

    redisTemplate.opsForValue().set("staticPath", staticPath);
  }
}
