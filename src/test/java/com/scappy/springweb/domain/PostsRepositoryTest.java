package com.scappy.springweb.domain;

import com.scappy.springweb.domain.posts.Posts;
import com.scappy.springweb.domain.posts.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        /**
         * 이후 테스트 코드에 영향을 끼치지 안하기 위해
         * 테스트 메소드가 끝날때마다 repository 전체를 비우는 코드
         */
        postsRepository.deleteAll();
    }

    @Test
    public void getPostsSave() {
        // given (테스트 기반 환경 구축) --> BDD(Behavior Driven Development)
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("scappyhw@kakao.com")
                .build());

        // when (테스트하고자 하는 행위 선언)
        List<Posts> postsList = postsRepository.findAll();

        // then (테스트 결과 검증)
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle().equals("테스트 게시글"));
        assertThat(posts.getContent().equals("테스트 본문"));
    }

    @Test
    public void testBaseTimeEntity() {
        // given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("scappyhw@kakao.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
