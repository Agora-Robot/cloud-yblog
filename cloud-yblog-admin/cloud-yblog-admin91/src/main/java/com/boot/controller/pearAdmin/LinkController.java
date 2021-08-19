package com.boot.controller.pearAdmin;

import com.alibaba.fastjson.JSON;
import com.boot.annotation.Operation;
import com.boot.data.ResponseData.layuiData;
import com.boot.data.ResponseData.layuiJSON;
import com.boot.feign.article.LinkFeign;
import com.boot.feign.article.fallback.LinkFallbackFeign;
import com.boot.pojo.Link;
import com.boot.utils.SnowId;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 游政杰
 *
 */
@Controller("pearLinkController")
@RequestMapping(path = "/pear")
@CrossOrigin
public class LinkController {


    @Autowired
    private LinkFallbackFeign linkFallbackFeign;

    @Autowired
    private LinkFeign linkFeign;

    /**
     *
     * @param page layui分页默认会传page和limit的值，所以要进行接收
     * @param limit
     * @return json
     */
    @ResponseBody
    @RequestMapping(path = "/linkData")
    public String linkData(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "6") int limit,
                           @RequestParam(value = "title",defaultValue = "")String title){

        if(StringUtils.isBlank(title)){
            layuiData<Link> linklayuiData = new layuiData<>();
            PageHelper.startPage(page,limit);
            List<Link> links = linkFallbackFeign.selectAllLink();
            int count = linkFallbackFeign.linkCount();
            linklayuiData.setCode(0);
            linklayuiData.setMsg("");
            linklayuiData.setCount(count);
            linklayuiData.setData(links);
            return JSON.toJSONString(linklayuiData);
        }else {

            layuiData<Link> linklayuiData = new layuiData<>();

            PageHelper.startPage(page, limit);
            List<Link> links = linkFallbackFeign.selectLinkByTitle(title);

            int count = linkFallbackFeign.selectCountByTitle(title);

            linklayuiData.setMsg("");
            linklayuiData.setCode(0);
            linklayuiData.setData(links);
            linklayuiData.setCount(count);
            return JSON.toJSONString(linklayuiData);
        }

    }


    @RequestMapping(path = "/tolink")
    public String toaddLink(){

        return "back/newback/article/module/addLink";
    }

    @Operation("新增友链")
    @RequestMapping(path = "/add/link")
    @ResponseBody
    public String addLink(Link link){

        layuiJSON json=new layuiJSON();

        try {
            link.setId(SnowId.nextId());
            linkFeign.insertLink(link);

            json.setMsg("新增友链成功");
            json.setSuccess(true);
            return JSON.toJSONString(json);

        }catch (Exception e){

            e.printStackTrace();
            json.setMsg("新增友链失败");
            json.setSuccess(false);
            return JSON.toJSONString(json);
        }

    }

    @RequestMapping(path = "/toModifyLink")
    public String toModifyLink(int linkid,String title,String link, Model model){

        model.addAttribute("id",linkid);
        model.addAttribute("title",title);
        model.addAttribute("link",link);

        return "back/newback/article/module/modifyLink";
    }

    @Operation("修改友链信息")
    @RequestMapping(path = "/modify/link")
    @ResponseBody
    public String modifyLink(Link link){

        layuiJSON json=new layuiJSON();
        try {

            linkFeign.updateLink(link);
            json.setSuccess(true);
            json.setMsg("修改友链成功");
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            json.setMsg("修改友链失败");
            json.setSuccess(false);
            return JSON.toJSONString(json);
        }

    }


    //删除友链
    @Operation("删除友链")
    @RequestMapping(path = "/delete/link/{id}")
    @ResponseBody
    public String deleteLink(@PathVariable("id") int id){
        layuiJSON json=new layuiJSON();
        try {

            linkFeign.deleteLink(id);
            json.setSuccess(true);
            json.setMsg("删除友链成功");
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            json.setMsg("删除友链失败");
            json.setSuccess(false);
            return JSON.toJSONString(json);
        }
    }


    //批量删除友链
    @Operation("批量删除友链")
    @RequestMapping(path = "/batchRemove/link/{ids}")
    @ResponseBody
    public String batchRemoveLink(@PathVariable("ids") String ids){
        layuiJSON json=new layuiJSON();
        try {

            String[] split = ids.split(",");
            for (String s : split) {
                linkFeign.deleteLink(Integer.parseInt(s));
            }

            json.setSuccess(true);
            json.setMsg("批量删除友链成功");
            return JSON.toJSONString(json);
        }catch (Exception e){
            e.printStackTrace();
            json.setMsg("批量删除友链失败");
            json.setSuccess(false);
            return JSON.toJSONString(json);
        }
    }


}
