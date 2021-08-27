package com.boot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 游政杰
 * 2021/8/27 12:12
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableAdminServer //说明这个SpringBoot应用是SpringBoot admin server主程序
public class MonitorApplication {

  public static void main(String[] args) {
      SpringApplication.run(MonitorApplication.class,args);
  }
}
