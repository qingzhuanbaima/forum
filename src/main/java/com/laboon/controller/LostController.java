package com.laboon.controller;


import com.laboon.entity.Lostlist;
import com.laboon.repository.LostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author laboon
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/lost")
public class LostController {
    @Autowired
    LostRepository lostRepository;

    @GetMapping("/findAll")
    public List<Lostlist> findAll(){
        return lostRepository.findAll();
    }

    /**
     * 发布失物招领
     * @param lostlist
     * @return
     */
    @PostMapping("/lostPost")
    public String lostPost(@RequestBody Lostlist lostlist) {
        Lostlist result = lostRepository.save(lostlist);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 删除失物招领
     * @param id
     */
    @DeleteMapping("/deleteByID/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        lostRepository.deleteById(id);
    }
}
