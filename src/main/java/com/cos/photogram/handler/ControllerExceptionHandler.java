package com.cos.photogram.handler;

import com.cos.photogram.handler.ex.CustomValidationException;
import com.cos.photogram.util.Script;
import com.cos.photogram.web.dto.CMRespDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e) {
        // Comparison of CMRespDto, Script
        // 1. Script is better for response with client
        // 2. Ajax communication - CMRespDto
        // 3. Android communication - CMRespDto
        return Script.back(e.getErrorMap().toString());
    }

}
