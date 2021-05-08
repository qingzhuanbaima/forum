package com.laboon.controller;


import com.laboon.entity.Notice;
import com.laboon.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author laboon
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeRepository noticeRepository;

    /**
     * 添加公告
     *
     * @param notice
     * @return
     */
    @PostMapping("/noticePost")
    public String suggest(@RequestBody Notice notice) {
        Notice result = noticeRepository.save(notice);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 删除公告
     * @param id
     */
    @DeleteMapping("/deleteByID/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        noticeRepository.deleteById(id);
    }
}
