package shaomai;

import shaomai.model.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static shaomai.Code.UPLOAD_FAIL;

@ControllerAdvice
public class AllExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ErrorResponse errorResponse(Exception e) {
        ErrorResponse errorResponse= new ErrorResponse(UPLOAD_FAIL, e.getMessage());
        errorResponse.data = e.getMessage();
        return errorResponse;
    }
}
