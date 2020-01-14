package com.scappy.springweb.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    /**
     * @Query 를 사용하면 SpringDataJpa 에서 제공하지 않는 메소드를 사용 가능하도록 해준다.
     * @return
     */
    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();

}
