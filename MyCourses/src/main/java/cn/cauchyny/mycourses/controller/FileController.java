package cn.cauchyny.mycourses.controller;

import cn.cauchyny.mycourses.service.FileService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileController {

    private static final Log log = LogFactory.getLog(UserController.class);

    @Autowired
    private FileService fileService;

    @PostMapping("/uploadCourseware")
    public String uploadCourseware(@RequestParam("id") String id, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                fileService.saveCourseware(id, file);
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败：" + e.getMessage();
            }
            return "success";
        } else {
            return "fail";
        }
    }

    @PostMapping("/uploadHomework")
    public String uploadCourseware(@RequestParam("id") String id, @RequestParam("recordId") String recordId, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                fileService.saveHomework(id, recordId, file);
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败：" + e.getMessage();
            }
            return "success";
        } else {
            return "fail";
        }
    }

    @PostMapping("/getCourseware")
    public String getCourseware(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        List<String> fileNameList = fileService.getCourseware(id);
        return JSONObject.toJSONString(fileNameList);
    }

    @PostMapping("/getHomework")
    public String getHomework(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        List<String> fileNameList = fileService.getHomework(id);
        return JSONObject.toJSONString(fileNameList);
    }

    @PostMapping("/downloadFile")
    public ResponseEntity<InputStreamResource> downloadFile(@RequestBody Map<String, String> map)
            throws IOException {
        String id = map.get("id");
        String type = map.get("type");
        String name = map.get("name");
        String sep = File.separator;
        String filePath = System.getProperty("user.dir")+sep+"src"+sep+"main"+sep+"resources"+sep+"data"+sep+id+sep+type+sep+name;

        FileSystemResource file = new FileSystemResource(filePath);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }
}
