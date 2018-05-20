package shaomai;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import shaomai.model.Response;

import static shaomai.Code.UPLOAD_FAIL;

@ControllerAdvice
public class AllExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public Response<String> errorResponse(Exception e) {
        Response<String> errorResponse = new Response<>(UPLOAD_FAIL, e.getMessage(), e.getMessage());
        return errorResponse;
    }
}
