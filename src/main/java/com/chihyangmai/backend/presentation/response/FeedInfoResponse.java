package com.chihyangmai.backend.presentation.response;

import com.chihyangmai.backend.application.dto.ContentDto;
import com.chihyangmai.backend.application.dto.FeedDto;
import com.chihyangmai.backend.application.dto.UserDto;
import com.chihyangmai.backend.domain.entity.Content;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FeedInfoResponse {

    private Long id;

    private String content;

    private String tag;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created_time;

    private UserDto writer;

    private List<ContentDto> image_urls = new ArrayList<>();

    public static FeedInfoResponse from (FeedDto dto) {
        return FeedInfoResponse.builder()
                .id(dto.getId())
                .content(dto.getContent())
                .tag(dto.getTag())
                .created_time(dto.getCreated_time())
                .writer(dto.getWriter())
                .image_urls(dto.getImageUrlsDto())
                .build();
    }

}
