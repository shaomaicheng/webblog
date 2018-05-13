package shaomai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Main {

    @RequestMapping("/")
    String home() {
        return "/";
    }

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }
}
