package com.boot.controller;

import com.boot.service.AuthorityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/feign/authority")
@Api("权限Api")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @ResponseBody
    @GetMapping(path = "/selectAuthorityByid")
    public String selectAuthorityByid(@RequestParam("authorityid") int authorityid){

        return authorityService.selectAuthorityByid(authorityid);
    }


}
