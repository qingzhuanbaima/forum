package com.laboon.controller;


import com.laboon.entity.Cmtchild;
import com.laboon.entity.Comments;
import com.laboon.repository.CmtchildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author laboon
 * @since 2021-05-24
 */
@RestController
@RequestMapping("/cmtchild")
public class CmtchildController {
    @Autowired
    CmtchildRepository cmtchildRepository;

    @GetMapping("/getcmtchild")
    private List<Cmtchild> findbycid(int cid) {
        return cmtchildRepository.findAllByCmtId(cid);
    }

    @PostMapping("/addcmtchild")
    public String addComment(@RequestBody Cmtchild cmtchild) {
        Cmtchild result = cmtchildRepository.save(cmtchild);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }
}
