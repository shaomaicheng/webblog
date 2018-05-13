package shaomai.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseBooleanData {
    @JsonProperty("is_success")
    public boolean isSuccess;

    public BaseBooleanData(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
