package com.scappy.springweb.service;

import com.scappy.springweb.domain.posts.PostsRepository;
import com.scappy.springweb.domain.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class PostsService {

    private PostsRepository postsRepository;

    /**
     * 호출 시 저장한 게시글의 id를 알수있도록 리턴 타입을 Long 으로 지정하고 .getId() 를 반환값으로 한다.
     * Entity 를 바로 받지 않고, save 용 DTO 인 PostsSaveRequestDto 를 받아서 저장한다.
     * @param dto
     * @return
     */
    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }
}
