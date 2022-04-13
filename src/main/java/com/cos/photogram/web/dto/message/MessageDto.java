package com.cos.photogram.web.dto.message;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class MessageDto {

        @NotBlank
        private String content;
        @NotNull
        private Integer fromUserId;
        @NotNull
        private Integer toUserId;

}
