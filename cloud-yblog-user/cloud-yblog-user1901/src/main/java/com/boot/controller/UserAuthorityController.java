package com.boot.controller;

import com.boot.service.UserAuthorityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/feign/userauthority")
@Api("用户权限Api")
public class UserAuthorityController {

  @Autowired private UserAuthorityService userAuthorityService;

  @ResponseBody
  @GetMapping(path = "/selectAuthorityID")
  public int selectAuthorityID(@RequestParam("userid") long userid) {

    return userAuthorityService.selectAuthorityID(userid);
  }


}
