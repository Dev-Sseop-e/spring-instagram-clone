package com.cos.photogram.web.dto.subsribe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubscribeDto {

    private int id;
    private String username;
    private String profileImageUrl;
    private Integer subscribeState;
    private Integer equalUserState;

}
