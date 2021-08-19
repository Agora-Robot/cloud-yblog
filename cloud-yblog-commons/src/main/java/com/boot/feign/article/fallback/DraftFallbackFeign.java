package com.boot.feign.article.fallback;


import com.boot.feign.article.fallback.impl.DraftFallbackFeignImpl;
import com.boot.pojo.Draft;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@FeignClient(value = "cloud-yblog-article",fallback = DraftFallbackFeignImpl.class)
public interface DraftFallbackFeign {

    @ResponseBody
    @GetMapping(path = "/feign/draft/selectDraftByTitle")
    public List<Draft> selectDraftByTitle(@RequestParam("title") String title);


    @ResponseBody
    @GetMapping(path = "/feign/draft/selectAllDraft")
    public List<Draft> selectAllDraft(@RequestParam("username") String username);


    @ResponseBody
    @GetMapping(path = "/feign/draft/selectDraftCount")
    public int selectDraftCount(@RequestParam("username") String username);

    @ResponseBody
    @GetMapping(path = "/feign/draft/selectDraftByID")
    public Draft selectDraftByID(@RequestParam("draftid") long draftid);



}
