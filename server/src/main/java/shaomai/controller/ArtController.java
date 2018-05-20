package shaomai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shaomai.Code;
import shaomai.exception.ArtSelectException;
import shaomai.model.Response;
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
     *
     * @param pageNO
     * @param pageSize
     * @return
     */
    @RequestMapping("/artlist")
    public Response<ArtListBean> getAllArts(
            @RequestParam("pageNo") int pageNO,
            @RequestParam("pageSize") int pageSize) throws ArtSelectException {
        List<ArtBean> arts = artService.getAllArts(pageNO, pageSize);
        int total = artService.artTotal();
        ArtListBean artListBean = new ArtListBean(total, arts);
        Response<ArtListBean> artResponse = new Response<>(OK_STATUS, "文章列表", artListBean);
        return artResponse;
    }

    @RequestMapping("/art/{id}")
    public Response<ArtBean> getArtById(@PathVariable("id") int id) throws ArtSelectException {
        ArtBean artBean = artService.getArtById(id);
        Response<ArtBean> response = new Response<>(Code.OK_STATUS, "查询文章成功", artBean);
        return response;
    }
}
