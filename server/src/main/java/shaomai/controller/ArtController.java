package shaomai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shaomai.model.p.ArtBean;
import shaomai.model.http.ArtResponse;
import shaomai.model.v.ArtListBean;
import shaomai.service.ArtService;
import static shaomai.Code.OK_STATUS;
import java.util.List;

@RestController
public class ArtController {

    @Autowired
    private ArtService artService;

    /**
     * 分页查询所有的文章
     * @param pageNO
     * @param pageSize
     * @return
     */
    @RequestMapping("/artlist")
    public ArtResponse getAllArts(
            @RequestParam("pageNo") int pageNO,
            @RequestParam("pageSize")int pageSize)
    {
        List<ArtBean> arts = artService.getAllArts(pageNO,pageSize);
        int total = artService.artTotal();
        ArtListBean artListBean = new ArtListBean(total, arts);
        ArtResponse artResponse = new ArtResponse(OK_STATUS, "文章列表");
        artResponse.data = artListBean;
        return artResponse;
    }
}
