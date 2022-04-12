package com.cos.photogram.web.dto.comment;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// @NotNull: check null
// @NotEmpty: check the empty value or null
// @NotBlank: check the empty value or null or blank(space)

@Data
public class CommentDto {

    @NotBlank
    private String content;
    @NotNull
    private Integer imageId;

}
