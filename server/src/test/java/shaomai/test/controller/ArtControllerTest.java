package shaomai.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import shaomai.Application;
import shaomai.model.http.ArtResponse;
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
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("pageNo", "1");
        params.add("pageSize", "3");
        ArtResponse response = restTemplate.getForObject("http://localhost:" + port + "/artlist?pageSize=3&pageNo=1",ArtResponse.class);
        assertEquals(3, response.data.getArts().size());
    }
}
