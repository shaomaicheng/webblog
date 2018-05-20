package shaomai.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import shaomai.Application;
import shaomai.model.Response;
import shaomai.model.p.ArtBean;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class ArtControllerTest {
    @LocalServerPort
    private int port;
    private RestTemplate restTemplate = new RestTemplate();
    @Test
    public void getAllArtsTest() {
        Response response = restTemplate.getForObject("http://localhost:" + port + "/artlist?pageSize=3&pageNo=1", Response.class);
        List<ArtBean> artBeans = (List<ArtBean>) ((LinkedHashMap)response.data).get("arts");
        assertEquals(3, artBeans.size());
    }
}
