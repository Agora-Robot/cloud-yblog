package com.boot.feign.article;


import com.boot.pojo.Article;
import com.boot.pojo.Draft;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "cloud-yblog-article")
public interface DraftFeign {


    @ResponseBody
    @PostMapping(path = "/feign/draft/publishDraft")
    public String publishDraft(@RequestBody Article article,
                               @RequestParam("editArticleId") long editArticleId);

    @ResponseBody
    @PostMapping(path = "/feign/draft/modifyDraft")
    public String modifyDraft(@RequestBody Draft draft);


    @ResponseBody
    @PostMapping(path = "/feign/draft/addDraft")
    public String addDraft(@RequestBody Draft draft);


    @ResponseBody
    @GetMapping(path = "/feign/draft/deleteDraftByID")
    public String deleteDraftByID(@RequestParam("id") long id);
}
