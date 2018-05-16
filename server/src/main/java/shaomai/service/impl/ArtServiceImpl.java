package shaomai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shaomai.dao.ArtDao;
import shaomai.model.p.ArtBean;
import shaomai.service.ArtService;

import java.util.List;
@Service
public class ArtServiceImpl implements ArtService {
    @Autowired
    private ArtDao artDao;
    @Override
    public List<ArtBean> getAllArts(int pageNo,int pageSize) {
        return artDao.selectAll(pageNo, pageSize);
    }

    @Override
    public int artTotal() {
        return artDao.artTotal();
    }
}
