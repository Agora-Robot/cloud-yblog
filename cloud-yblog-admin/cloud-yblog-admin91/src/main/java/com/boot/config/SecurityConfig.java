package com.boot.config;

import com.alibaba.fastjson.JSON;
import com.boot.constant.LoginType;
import com.boot.constant.ThemeConstant;
import com.boot.data.ResponseData.RememberJSON;
import com.boot.feign.log.LoginLogFeign;
import com.boot.feign.system.fallback.SettingFallbackFeign;
import com.boot.feign.user.fallback.UserDetailFallbackFeign;
import com.boot.feign.user.fallback.UserFallbackFeign;
import com.boot.filter.VerifyCodeFilter;
import com.boot.pojo.LoginLog;
import com.boot.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/** @author 游政杰 */
@Configuration
@EnableWebSecurity // 开启SpringSecurity的功能
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启注解控制权限
@Slf4j
@Order(5)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired DataSource dataSource;

  @Autowired private RedisTemplate redisTemplate;

  @Autowired private VerifyCodeFilter verifyCodeFilter;

  private final String key = "@%&^=*remember-yblog=@#&%"; // 密钥，切勿泄露出去

  private final String REMEMBER_KEY = "REMEMBER_"; // 记住我的Redis key前缀

  @Autowired private UserFallbackFeign userFallbackFeign;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //        String sql="select username,authority_id from t_user,t_user_authority where username =
    // ? and t_user.id=t_user_authority.id";
    String sql =
        "select u.username,a.authority from t_user u,t_authority a,"
            + "t_user_authority ua where ua.user_id=u.id "
            + "and ua.authority_id=a.id and u.username =?";
    auth.jdbcAuthentication()
        .dataSource(dataSource)
        .passwordEncoder(encoder)
        .usersByUsernameQuery("select username,password,valid from t_user where username = ?")
        .authoritiesByUsernameQuery(sql);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.formLogin()
        .loginPage("/admin/nologin") // 登录页接口
        .and()
        // 不写这段代码，druid监控sql将失效（原因未明）
        .csrf()
        .ignoringAntMatchers("/druid/**")
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/admin/nologin")
        .logoutSuccessHandler(new LogoutSuccessHandler() {
          @Override
          public void onLogoutSuccess(
                  HttpServletRequest httpServletRequest,
                  HttpServletResponse httpServletResponse,
                  Authentication authentication)
                  throws IOException, ServletException {

            log.info("退出成功");

            // 退出从Redis删除记住我记录
            redisTemplate.delete(REMEMBER_KEY + IpUtils.getIpAddr(httpServletRequest));
            httpServletResponse.sendRedirect("/admin/nologin");
          }
        })
        .and()
        .authorizeRequests()
        .antMatchers("/page/**")
        .permitAll()
        .antMatchers("/")
        .permitAll()
        .antMatchers("/loginPage")
        .permitAll()
        .antMatchers("/login")
        .permitAll()
        .antMatchers("/article/**")
        .permitAll()
        .antMatchers("/druid/**")
        .permitAll()
        // 这句代码一定要加，为了防止spring过滤静态资源
        .antMatchers(
            "/user/**",
            "/email/**",
            "/plugins/**",
            "/user_img/**",
            "/article_img/**",
            "/assets/**",
            "/back/**",
            "/user/**",
            "/pear-admin/**",
            "/component/**",
            "/static/**",
            "/pear/captcha",
            "/config/**",
            "/favicon.ico")
        .permitAll()
        .antMatchers(
            "/monitor/**",
            "/usermanager/**",
            "/article/updateAllowComment",
            "/link/**",
            "/visitor/**",
            "/chart/**",
            "/black/**")
        .hasRole("admin")
        .antMatchers("/myuser/**", "/img/**", "/catchArticle/**", "/like/**", "/admin/")
        .hasAnyRole("admin", "common")
        .antMatchers("/sliderCaptcha/**", "/logout")
        .permitAll()
        .anyRequest()
        .permitAll()
        .and()
        //                如果不加这段代码，iframe嵌入的Druid监控界面会出现（使用 X-Frame-Options 拒绝网页被 Frame 嵌入）
        .headers()
        .frameOptions()
        .disable();
  }

}
