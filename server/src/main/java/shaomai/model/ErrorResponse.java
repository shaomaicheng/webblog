package shaomai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse extends BaseResponse {
    @JsonProperty("error_data")
    public String data;

    public ErrorResponse(int code, String message) {
        super(code, message);
    }
}
