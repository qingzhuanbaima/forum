package com.laboon.controller;


import com.laboon.entity.Article;
import com.laboon.entity.Comments;
import com.laboon.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author laboon
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsRepository commentsRepository;

    /**
     * 获取评论
     * @param id
     * @return
     */
    @GetMapping("/getcomment")
    public List<Comments> finAllById(@RequestParam("id") Integer id){
        return commentsRepository.findAllByAid(id);
    }

    /**
     * 根据用户名找评论
     * @param username
     * @return
     */
    @GetMapping("/byuser")
    public List<Comments> finAllById(@RequestParam("username") String username){
        return commentsRepository.findAllByUsername(username);
    }


    /**
     * 添加评论
     * @param comment
     * @return
     */
    @PostMapping("/addcomment")
    public String addComment(@RequestBody Comments comment) {
        Comments result = commentsRepository.save(comment);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }
}
