package io.shaomai.controller;

import io.shaomai.model.BaseBooleanData;
import io.shaomai.model.BaseBooleanResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.shaomai.Code.OK_STATUS;

@RestController
public class UploadMdFileController {
    @RequestMapping(value = "/uploadMdFile", method = RequestMethod.POST)
    @ResponseBody
    public BaseBooleanResponse uploadMdFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            File dir = new File(getClass().getResource("/").getPath() + "/public/arts");
            if (!dir.exists()) {
                System.out.println("dir do not exists, create it");
                dir.mkdirs();
            } else {
                System.out.println("dir is already exists");
            }
            System.out.println("public dir is " + dir.getAbsolutePath());
            File outFile = new File(dir, file.getOriginalFilename());
            try {
                if (!outFile.exists()) {
                    outFile.createNewFile();
                }
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile));
                bos.write(file.getBytes());
                bos.flush();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new IOException("文件上传失败");
            }
        }
        BaseBooleanResponse response = new BaseBooleanResponse(OK_STATUS, "文件上传成功");
        BaseBooleanData data = new BaseBooleanData(true);
        response.data = data;
        return response;
    }

}

