package shaomai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseBooleanResponse extends BaseResponse {
    @JsonProperty("data")
    public BaseBooleanData data;

    public BaseBooleanResponse(int code, String message) {
        super(code, message);
    }
}