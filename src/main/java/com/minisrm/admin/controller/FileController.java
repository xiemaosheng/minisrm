package com.minisrm.admin.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController extends BaseController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Object fileUpload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        if (StringUtils.isEmpty(fileName)){
            fileName = "test.png";
        }
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        // 上传后的路径
        String filePath = "D://temp-rainy//";
//         String filePath = "/opt/pic/goods/";
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String filename = "/opt/pic/goods/" + fileName;
        String filename = filePath + fileName;
        JSONObject object = new JSONObject();
        object.put("fileName", filename);
        return object;
    }

    @RequestMapping(value = "/upload/commentPicture", method = RequestMethod.POST)
    @ResponseBody
    public Object commentPicture(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        if (StringUtils.isEmpty(fileName)){
            fileName = "commentPicture.png";
        }
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        // 上传后的路径
        String filePath = "D://temp-rainy//";
//        String filePath = "/opt/pic/commentPicture/";
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String filename = "/opt/pic/commentPicture/" + fileName;
        String filename = filePath + fileName;
        JSONObject object = new JSONObject();
        object.put("fileName", filename);
        return object;
    }

    @RequestMapping(value = "/upload/commentVideo", method = RequestMethod.POST)
    @ResponseBody
    public Object commentVideo(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        if (StringUtils.isEmpty(fileName)){
            fileName = "commentPicture.mp4";
        }
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        // 上传后的路径
        String filePath = "D://temp-rainy//";
//        String filePath = "/opt/pic/commentVideo/";
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String filename = "/opt/pic/commentVideo/" + fileName;
        String filename = filePath + fileName;
        JSONObject object = new JSONObject();
        object.put("fileName", filename);
        return object;
    }
}
