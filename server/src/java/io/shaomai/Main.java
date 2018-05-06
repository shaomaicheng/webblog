package io.shaomai;

import io.shaomai.controller.UploadMdFileController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@Import({UploadMdFileController.class, AllExceptionHandler.class})
public class Main {

    @RequestMapping("/")
    String home() {
        return "/";
    }

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }
}
