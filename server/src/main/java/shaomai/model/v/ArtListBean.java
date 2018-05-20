package shaomai.model.v;

import com.fasterxml.jackson.annotation.JsonProperty;
import shaomai.model.p.ArtBean;

import java.util.List;

public class ArtListBean {
    @JsonProperty("arts")
    private List<ArtBean> arts;

    @JsonProperty("total")
    private int total;

    public ArtListBean() {
    }

    public ArtListBean(int total, List<ArtBean> arts) {
        this.total = total;
        this.arts = arts;
    }

    public List<ArtBean> getArts() {
        return arts;
    }

    public void setArts(List<ArtBean> arts) {
        this.arts = arts;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
