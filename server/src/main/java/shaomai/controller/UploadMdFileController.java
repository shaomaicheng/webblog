package shaomai.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shaomai.model.Response;
import shaomai.service.UploadService;

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
    public Response<Boolean> uploadMdFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("author") String author
    ) throws IOException {
        uploadService.uploadFile(file, title, author);
        Response<Boolean> response = new Response<>(OK_STATUS, "文件上传成功", true);
        return response;
    }

}

