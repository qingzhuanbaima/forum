package com.laboon.controller;


import com.laboon.entity.Lost;
import com.laboon.entity.Suggestion;
import com.laboon.repository.SuggestionRepository;
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
@RequestMapping("/suggestion")
public class SuggestionController {

    @Autowired
    SuggestionRepository suggestionRepository;

    @GetMapping("/findAll")
    public List<Suggestion> findAll(){
        return suggestionRepository.findAll();
    }

    /**
     * 添加建议
     * @param suggestion
     * @return
     */
    @PostMapping("/suggestionPost")
    public String suggest(@RequestBody Suggestion suggestion) {
        Suggestion result = suggestionRepository.save(suggestion);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }
}
