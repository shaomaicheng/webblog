package shaomai.controller;

import shaomai.model.v.BaseBooleanData;
import shaomai.model.BaseBooleanResponse;
import shaomai.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static shaomai.Code.OK_STATUS;

@RestController
public class UploadMdFileController {
    protected UploadService uploadService;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UploadMdFileController(UploadService service) {
        uploadService = service;
    }

    @RequestMapping(value = "/uploadMdFile", method = RequestMethod.POST)
    @ResponseBody
    public BaseBooleanResponse uploadMdFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("author") String author
    ) throws IOException {
        uploadService.uploadFile(file, title, author);
        BaseBooleanResponse response = new BaseBooleanResponse(OK_STATUS, "文件上传成功");
        BaseBooleanData data = new BaseBooleanData(true);
        response.data = data;
        return response;
    }

}

