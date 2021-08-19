package com.boot.feign.article.fallback;

import com.boot.feign.article.fallback.impl.LinkFallbackFeignImpl;
import com.boot.pojo.Link;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@FeignClient(value = "cloud-yblog-article",fallback = LinkFallbackFeignImpl.class)
public interface LinkFallbackFeign {


    @ResponseBody
    @GetMapping(path = "/feign/link/selectAllLink")
    public List<Link> selectAllLink();

    @ResponseBody
    @GetMapping(path = "/feign/link/linkCount")
    public int linkCount();

    @ResponseBody
    @GetMapping(path = "/feign/link/selectLinkByTitle")
    public List<Link> selectLinkByTitle(@RequestParam("title") String title);


    @ResponseBody
    @GetMapping(path = "/feign/link/selectCountByTitle")
    public int selectCountByTitle(@RequestParam("title") String title);






}
