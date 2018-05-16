package shaomai.service;

import shaomai.model.p.ArtBean;

import java.util.List;

public interface ArtService {
    List<ArtBean> getAllArts(int pageNo,int pageSize);
    int artTotal();
}
