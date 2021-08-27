package com.boot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 游政杰
 * 2021/8/27 12:12
 */
@SpringBootApplication
@EnableAdminServer //说明这个SpringBoot应用是SpringBoot admin server主程序
public class MonitorApplication8901 {

  public static void main(String[] args) {
      SpringApplication.run(MonitorApplication8901.class,args);
  }
}
