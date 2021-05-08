package com.laboon.repository;

import com.laboon.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments,Integer> {

    List<Comments> findAllByAid(Integer id);

    List<Comments> findAllByUsername(String username);

}
