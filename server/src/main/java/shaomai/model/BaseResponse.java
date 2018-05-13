package shaomai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponse {
    @JsonProperty("code")
    public int code;
    @JsonProperty("msg")
    public String message;

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
