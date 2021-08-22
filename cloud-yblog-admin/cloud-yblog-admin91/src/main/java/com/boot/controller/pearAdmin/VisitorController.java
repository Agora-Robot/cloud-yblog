package com.boot.controller.pearAdmin;

import com.alibaba.fastjson.JSON;
import com.boot.constant.Constant;
import com.boot.data.ResponseData.ResponseJSON;
import com.boot.data.ResponseData.layuiData;
import com.boot.feign.log.fallback.VisitorFallbackFeign;
import com.boot.pojo.Visitor;
import com.boot.utils.IpToAddressUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 游政杰
 *
 */
@Controller("pearVisitorController")
@RequestMapping(path = "/pear")
@CrossOrigin
public class VisitorController {

    @Autowired
    private VisitorFallbackFeign visitorFallbackFeign;


    @ResponseBody
    @RequestMapping(path = "/visitorData")
    public String visitorData(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "limit", defaultValue = "10") int limit){


        layuiData<Visitor> visitorlayuiData = new layuiData<>();

        List<Visitor> visitors = visitorFallbackFeign.selectVisitor(page, limit);

        int count = visitorFallbackFeign.selectVistorCount();
        visitorlayuiData.setCode(0);
        visitorlayuiData.setCount(count);
        visitorlayuiData.setMsg("");
        visitorlayuiData.setData(visitors);

        return JSON.toJSONString(visitorlayuiData);
    }


    @RequestMapping(path = "/searchIpaddress")
    @ResponseBody
    public String searchIpAddress(String ip1, String ip2, String ip3, String ip4) {
        String ip = ip1 + "." + ip2 + "." + ip3 + "." + ip4; //真正的ip
        System.out.println(ip);

        String cityInfo = IpToAddressUtil.getCityInfo(ip);

        ResponseJSON responseJSON = new ResponseJSON();

        responseJSON.setData(cityInfo);

        responseJSON.setResult(Constant.SUCCESS);
        return JSON.toJSONString(responseJSON);
    }


}
