package com.boot.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 游政杰
 * 2021/5/20
 */
@Controller
@Api("注销 web api")
public class logoutController {


    @RequestMapping(path = "/logout")
    public void logout(HttpServletResponse response) throws IOException {

        response.sendRedirect("/admin/nologin");
    }


}
