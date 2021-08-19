package com.boot.controller.pearAdmin;

import com.alibaba.fastjson.JSON;
import com.boot.annotation.Operation;
import com.boot.annotation.Visitor;
import com.boot.data.ResponseData.layuiJSON;
import com.boot.feign.system.ImgFeign;
import com.boot.feign.system.fallback.ImgFallbackFeign;
import com.boot.feign.user.fallback.UserDetailFallbackFeign;
import com.boot.pojo.Img;
import com.boot.utils.FileUtil;
import com.boot.utils.SnowId;
import com.boot.utils.SpringSecurityUtil;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@Controller("pearFileController")
@RequestMapping(path = "/pear")
@CrossOrigin
public class FileController {

    @Autowired
    private ImgFallbackFeign imgFallbackFeign;

    @Autowired
    private ImgFeign imgFeign;

    //附件管理
    @Operation("进入附件管理页面")
    @Visitor(desc = "附件管理")
    @RequestMapping(path = "/toFileUpload")
    public String toFileUpload(Model model) {

        List<Img> imgs = imgFallbackFeign.selectAllImg();
        model.addAttribute("imgs", imgs);

        return "back/newback/article/img_list";
    }


    @Operation("附件上传")
    @RequestMapping(path = "/file/upload")
    @ResponseBody
    public String fileupload(MultipartFile[] files, HttpSession session, Model model) throws IOException {

        layuiJSON json = new layuiJSON();
        if (files.length > 0) { //如果有文件


            try {

                for (MultipartFile file : files) {
                    String bigImgPath = FileUtil.getBigImgPath();
                    String smallImgPath = FileUtil.getSmallImgPath();
                    if (!file.isEmpty()) {
                        //处理大图
                        InputStream inputStream = file.getInputStream();
                        byte bytes[] = new byte[inputStream.available()];
                        inputStream.read(bytes);

                        String randomName = FileUtil.getRandomName();
                        String fileSuffix = FileUtil.getFileSuffix(file.getOriginalFilename()); //后缀名
                        bigImgPath += randomName + "." + fileSuffix;
                        FileUtil.write(bigImgPath, bytes); //写入大图


                        //用google的图像处理工具处理缩略图

                        //缩略图文件名
                        String randomName2 = FileUtil.getRandomName(); //缩略图随机名
                        String fileSuffix2 = FileUtil.getFileSuffix(file.getOriginalFilename());
                        smallImgPath += randomName2 + "." + fileSuffix2;

                        Thumbnails.of(bigImgPath)
                                //图片尺寸
                                .size(256, 256)
                                //输出质量，0-1 ，越大图片质量越好
                                .outputQuality(0.9f)
                                /**
                                 * keepAspectRatio(false) 默认是按照比例缩放的,所以把它关掉
                                 */
                                .keepAspectRatio(false)
                                //输出到的文件全名
                                .toFile(smallImgPath);

                        String i1 = "/big_img/" + randomName + "." + fileSuffix; //大图，存入数据库的地址
                        String i2 = "/small_img/" + randomName2 + "." + fileSuffix;
                        imgFeign.addImgPath(SnowId.nextId(),i1, i2);
                    }
                }
                json.setMsg("上传附件成功");
                json.setSuccess(true);
                return JSON.toJSONString(json);
            } catch (Exception e) {
                e.printStackTrace();
                json.setMsg("上传附件失败");
                json.setSuccess(false);
                return JSON.toJSONString(json);
            }


        } else { //如果没有文件

            json.setMsg("没有添加附件，上传失败");
            json.setSuccess(false);
            return JSON.toJSONString(json);
        }

    }


    /**
     * 文件下载
     */
    @RequestMapping(path = "/file/download")
    public ResponseEntity<byte[]> downloadFile(@RequestParam(value = "f") long f) throws IOException {

        Img img = imgFallbackFeign.selectImgByid(f);
        String staticPath = FileUtil.getStaticPath();
        String big_img = img.getBig_img();
        staticPath += big_img;
        File file = new File(staticPath);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + file.getName());
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
        return responseEntity;
    }

    /**
     * 附件删除
     */
    @Operation("附件删除")
    @ResponseBody
    @RequestMapping(path = "/file/delete")
    public String fileDelete(long id) throws FileNotFoundException {
        layuiJSON json=new layuiJSON();


        try {
            Img img = imgFallbackFeign.selectImgByid(id);
            String big_img = img.getBig_img();
            String small_img = img.getSmall_img();

            String p = ResourceUtils.getURL("classpath:static").getPath();
            String path=p.substring(1,p.length());
            String big=path+big_img;
            String small=path+small_img;

            File bigFile = new File(big);
            File smallFile = new File(small);

            //删除服务器中的大图和缩略图文件
            if(bigFile.exists()){
                bigFile.delete();
            }
            if(smallFile.exists()){
                smallFile.delete();
            }

            //删除对应数据库记录
            imgFeign.deleteImgByid(id);
            json.setMsg("删除附件成功");
            json.setSuccess(true);
        }catch (Exception e){
            e.printStackTrace();
            json.setMsg("删除附件失败");
            json.setSuccess(false);
        }


        return JSON.toJSONString(json);
    }




}
