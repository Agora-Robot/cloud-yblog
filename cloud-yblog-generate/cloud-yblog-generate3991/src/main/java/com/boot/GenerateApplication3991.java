package com.boot;

import com.boot.config.GenerateProperties;
import com.boot.config.ScanClassProperties;
import com.boot.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 游政杰
 * 2021/9/5 12:40
 */
@SpringBootApplication
@Import(SwaggerConfig.class) //导入swaggerConfig的配置类
@EnableSwagger2  //开启Swagger2
@EnableConfigurationProperties(
        {
                ScanClassProperties.class,
                GenerateProperties.class
        }
        )
@EnableFeignClients
@EnableDiscoveryClient
public class GenerateApplication3991 {

  public static void main(String[] args) {
      SpringApplication.run(GenerateApplication3991.class,args);
  }
}