package shaomai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shaomai.dao.ArtDao;
import shaomai.exception.ArtSelectException;
import shaomai.model.p.ArtBean;
import shaomai.service.ArtService;

import java.util.List;
@Service
public class ArtServiceImpl implements ArtService {
    @Autowired
    private ArtDao artDao;
    @Override
    public List<ArtBean> getAllArts(int pageNo,int pageSize) throws ArtSelectException {
        try {
            return artDao.selectAll(pageNo, pageSize);
        } catch (Exception e) {
            throw new ArtSelectException("文章查询失败");
        }
    }

    @Override
    public int artTotal() throws ArtSelectException {
        try {
            return artDao.artTotal();
        } catch (Exception e) {
            throw new ArtSelectException("文章查询失败");
        }
    }
}
