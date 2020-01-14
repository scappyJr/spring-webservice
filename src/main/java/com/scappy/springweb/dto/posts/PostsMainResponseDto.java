package com.scappy.springweb.dto.posts;

import com.scappy.springweb.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Getter
public class PostsMainResponseDto {

    private Long id;
    private String title;
    private String author;
    private String modifiedDate;

    public PostsMainResponseDto(Posts entity) {
        id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    /**
     * View 영역에서는 LocalDateTime 타입을 모르기 때문에 인식할 수 있도록 문자열로 날짜 형식 변경
     * @param localDateTime
     * @return
     */
    private String toStringDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime).map(formatter::format).orElse("");
    }

}
