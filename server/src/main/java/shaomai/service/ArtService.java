package shaomai.service;

import shaomai.exception.ArtSelectException;
import shaomai.model.p.ArtBean;

import java.util.List;

public interface ArtService {
    List<ArtBean> getAllArts(int pageNo,int pageSize) throws ArtSelectException;
    int artTotal () throws ArtSelectException;
}
