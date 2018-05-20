package shaomai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shaomai.exception.ArtSelectException;
import shaomai.model.http.ArtResponse;
import shaomai.model.p.ArtBean;
import shaomai.model.v.ArtListBean;
import shaomai.service.ArtService;

import java.util.List;

import static shaomai.Code.OK_STATUS;

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
            @RequestParam("pageSize")int pageSize) throws ArtSelectException {
        List<ArtBean> arts = artService.getAllArts(pageNO,pageSize);
        int total = artService.artTotal();
        ArtListBean artListBean = new ArtListBean(total, arts);
        ArtResponse artResponse = new ArtResponse(OK_STATUS, "文章列表");
        artResponse.data = artListBean;
        return artResponse;
    }
}
