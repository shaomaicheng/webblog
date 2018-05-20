package shaomai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response<T> {
    @JsonProperty("code")
    public int code;
    @JsonProperty("msg")
    public String message;
    @JsonProperty("data")
    public T data;

    public Response() {
    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
