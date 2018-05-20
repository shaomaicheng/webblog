package shaomai.model.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import shaomai.Code;
import shaomai.model.BaseResponse;
import shaomai.model.v.ArtListBean;

public class ArtResponse extends BaseResponse {
    @JsonProperty("data")
    public ArtListBean data;

    public ArtResponse() {
        this(Code.OK_STATUS, "文章列表");
    }

    public ArtResponse(int code, String message) {
        super(code, message);
    }
}
