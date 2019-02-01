package cn.cauchyny.mycourses.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    private static final String root = System.getProperty("user.dir");
    private static final String sep = File.separator;

    private void ensurePath(String path) {
        File file = new File(path);
        if (!file.exists())
            file.mkdirs();
    }

    public String saveCourseware(String id, MultipartFile file) throws IOException {
        String filePath = root+sep+"src"+sep+"main"+sep+"resources"+sep+"data"+sep+id+sep+"courseware";
        ensurePath(filePath);
        saveFile(file, filePath+sep+file.getOriginalFilename());
        return "success";
    }

    public String saveHomework(String id, String recordId, MultipartFile file) throws IOException {
        String filePath = root+sep+"src"+sep+"main"+sep+"resources"+sep+"data"+sep+recordId+sep+"homework";
        ensurePath(filePath);
        saveFile(file, filePath+sep+id+"_"+file.getOriginalFilename());
        return "success";
    }

    private void saveFile(MultipartFile file, String path) throws IOException {
        File saveFile = new File(path);
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
        out.write(file.getBytes());
        out.flush();
        out.close();
    }

    public List<String> getCourseware(String id) {
        String filePath = root+sep+"src"+sep+"main"+sep+"resources"+sep+"data"+sep+id+sep+"courseware";
        return getFileList(filePath);
    }

    public List<String> getHomework(String id) {
        String filePath = root+sep+"src"+sep+"main"+sep+"resources"+sep+"data"+sep+id+sep+"homework";
        return getFileList(filePath);
    }

    private List<String> getFileList(String path) {
        File dir = new File(path);
        List<String> fileNameList = new ArrayList<>();
        if (dir.exists()) {
            for (File file : dir.listFiles())
                fileNameList.add(file.getName());
        }
        return fileNameList;
    }
}
