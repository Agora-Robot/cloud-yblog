package com.boot.controller.pearAdmin;

import com.alibaba.fastjson.JSON;
import com.boot.annotation.Operation;
import com.boot.constant.ThemeConstant;
import com.boot.data.ResponseData.layuiJSON;
import com.boot.feign.system.SettingFeign;
import com.boot.feign.system.fallback.SettingFallbackFeign;
import com.boot.pojo.Setting;
import com.boot.utils.FileUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(path = "/pear")
public class SettingController {

    private static List<String> themes = new ArrayList<>();

    @Autowired
    private SettingFallbackFeign settingFallbackFeign;

    @Autowired
    private SettingFeign settingFeign;



    static {

        themes.add("default");
        themes.add("calmlog");
    }

    @Operation("修改系统设置")
    @PostMapping(path = "/update/Setting")
    @ApiOperation("修改系统设置")
    @ResponseBody
    public String updateSetting(MultipartFile logo, String name, String foot, String theme, HttpSession session) throws IOException {

        layuiJSON json = new layuiJSON();

        try {
            boolean flag = logo.isEmpty(); //判断是否是空
            String logoPath = null;
            if (!flag) {
                InputStream inputStream = logo.getInputStream(); //获取文件流
                byte fileByteArray[] = new byte[inputStream.available()];
                inputStream.read(fileByteArray);//读取到一个字节数组中
                logoPath = FileUtil.writeImageLogo(logo.getOriginalFilename(), fileByteArray);

                Setting setting = settingFallbackFeign.selectUserSetting(name);
                String staticPath = FileUtil.getStaticPath();
                String s = staticPath + setting.getLogo();
                File file = new File(s); //如果当前这个头像不是默认的bloglogo.jpg就删除
                if (file.exists()) {
                    if (!file.getName().equals("bloglogo.jpg")) {
                        file.delete();
                    }
                }

            }
            Setting st = new Setting();
            st.setLogo(logoPath);
            st.setFoot(foot);
            st.setName(name);
            st.setTheme(theme);

            settingFeign.changeSettingByUser(st);

            //写入本地的jvm内存
            ThemeConstant.curTheme = st.getTheme();

            json.setMsg("修改系统设置成功");
            json.setSuccess(true);

            return JSON.toJSONString(json);
        } catch (Exception e) {
            e.printStackTrace();

            json.setMsg("修改系统设置失败");
            json.setSuccess(false);
            return JSON.toJSONString(json);
        }

    }

}
