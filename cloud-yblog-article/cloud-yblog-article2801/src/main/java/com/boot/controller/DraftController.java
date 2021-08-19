package com.boot.controller;


import com.boot.constant.Constant;
import com.boot.pojo.Article;
import com.boot.pojo.Draft;
import com.boot.service.DraftService;
import com.boot.utils.SnowId;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api("草稿箱Api")
@RequestMapping(path = "/feign/draft")
public class DraftController {

    @Autowired
    private DraftService draftService;

    @ResponseBody
    @GetMapping(path = "/selectDraftByTitle")
    public List<Draft> selectDraftByTitle(@RequestParam("title") String title){

        List<Draft> drafts = draftService.selectDraftByTitle(title);

        return drafts;
    }

    @ResponseBody
    @GetMapping(path = "/selectAllDraft")
    public List<Draft> selectAllDraft(@RequestParam("username") String username){

        List<Draft> drafts = draftService.selectAllDraft(username);

        return drafts;
    }

    @ResponseBody
    @GetMapping(path = "/selectDraftCount")
    public int selectDraftCount(@RequestParam("username") String username){

        int count = draftService.selectDraftCount(username);

        return count;
    }

    @ResponseBody
    @GetMapping(path = "/selectDraftByID")
    public Draft selectDraftByID(@RequestParam("draftid") long draftid){

        Draft draft = draftService.selectDraftByID(draftid);

        return draft;
    }

    @ResponseBody
    @PostMapping(path = "/publishDraft")
    public String publishDraft(@RequestBody Article article,
                               @RequestParam("editArticleId") long editArticleId){

        draftService.publishDraft(article, editArticleId);

        return Constant.OK;
    }

    @ResponseBody
    @PostMapping(path = "/modifyDraft")
    public String modifyDraft(@RequestBody Draft draft){

        draftService.modifyDraft(draft);

        return Constant.OK;
    }

    @ResponseBody
    @PostMapping(path = "/addDraft")
    public String addDraft(@RequestBody Draft draft){

        draft.setId(SnowId.nextId());

        draftService.addDraft(draft);

        return Constant.OK;
    }

    @ResponseBody
    @GetMapping(path = "/deleteDraftByID")
    public String deleteDraftByID(@RequestParam("id") long id){

        draftService.deleteDraftByID(id);

        return Constant.OK;
    }

}
