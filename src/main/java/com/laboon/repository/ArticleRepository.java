package com.laboon.repository;

import com.laboon.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Article findByUsername(String username);

    List<Article> findAllByUsername(String username);

    List<Article> findAllByClub(String club);

    List<Article> findAllByLabel(String label);

    List<Article> findByUsernameOrTitleOrContentLike(String username, String title, String content);

    /**
     * 点赞数加一
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "update article set star=star+1 where id=?1", nativeQuery = true)
    void updateStarById(int id);

    /**
     * 评论数加一
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "update article set comment=comment+1 where id=?1", nativeQuery = true)
    void updateCommentById(int id);
}
