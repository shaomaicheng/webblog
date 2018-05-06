package io.shaomai;

import io.shaomai.model.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static io.shaomai.Code.UPLOAD_FAIL;

@ControllerAdvice
public class AllExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ErrorResponse errorResponse(Exception e) {
        ErrorResponse errorResponse= new ErrorResponse(UPLOAD_FAIL, "文件上传失败");
        errorResponse.data = "文件上传失败";
        return errorResponse;
    }
}
