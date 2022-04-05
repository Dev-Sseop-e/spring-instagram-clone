package com.cos.photogram.handler;

import com.cos.photogram.handler.ex.CustomValidationApiException;
import com.cos.photogram.handler.ex.CustomValidationException;
import com.cos.photogram.util.Script;
import com.cos.photogram.web.dto.CMRespDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    // Comparison of CMRespDto and Script
    // 1. Response with client - Script
    // 2. Ajax communication - CMRespDto
    // 3. Android communication - CMRespDto

    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e) {
        return Script.back(e.getErrorMap().toString()); // return javascript
    }

    @ExceptionHandler(CustomValidationApiException.class)
    public ResponseEntity<CMRespDto<?>> validationApiException(CustomValidationApiException e) {
        return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST); // return data
    }

}
