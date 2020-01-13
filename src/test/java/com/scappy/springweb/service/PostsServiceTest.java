package com.scappy.springweb.service;

import com.scappy.springweb.domain.posts.PostsRepository;
import com.scappy.springweb.domain.posts.PostsSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void saveDtoDataToTable() {
        // given
        PostsSaveRequestDto dto = PostsSaveRequestDto.buil

        // when

        // then
    }

}
