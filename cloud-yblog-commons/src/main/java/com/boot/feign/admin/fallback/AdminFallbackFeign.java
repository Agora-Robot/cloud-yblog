package com.boot.feign.admin.fallback;

import com.boot.feign.admin.fallback.impl.AdminFallbackFeignImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@FeignClient(value = "cloud-yblog-admin" ,fallback = AdminFallbackFeignImpl.class)
public interface AdminFallbackFeign {



}
