package com.laboon.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.laboon.entity.Article;
import com.laboon.repository.ArticleRepository;
import com.laboon.utils.img.dao.ImgBase64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static org.json.JSONArray.*;
import static org.springframework.web.servlet.function.EntityResponse.fromObject;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;



    /**
     * @return+
     */
    @GetMapping("/findAll")
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    /**
     * 根据id找帖子
     *
     * @param id
     * @return
     */
    @GetMapping("/id")
    public Article findById(@RequestParam("id") Integer id) {
        return articleRepository.findById(id).get();
    }

    /**
     * 查找图片
     * @param imgid
     * @return
     */
    @GetMapping("/getimg")
    public String sendImg(String imgid){
        System.out.println("开始");
        return img2Base64(imgid);
    }

    /**
     * 根据用户名查找帖子
     *
     * @param username
     * @return
     */
    @GetMapping("/user")
    public List<Article> finAllByUsername(@RequestParam("username") String username) {
        return articleRepository.findAllByUsername(username);
    }

    /**
     * 根据club找帖子
     *
     * @param club
     * @return
     */
    @GetMapping("/club")
    public List<Article> findAllByClub(@RequestParam("label") String club) {
        return articleRepository.findAllByClub(club);
    }

    /**
     * 根据label找帖子
     *
     * @param label
     * @return
     */
    @GetMapping("/label")
    public List<Article> findAllByLabel(String label) {
        return articleRepository.findAllByLabel(label);
    }

    /**
     * 发表帖子
     *
     * @param
     * @param
     * @return
     */
    @PostMapping("/articlePost")
    public String articlePost(@RequestBody Article article) {
        Article result = articleRepository.save(article);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }
    @PostMapping("/imgsave")
    public String imgSave(@RequestBody String imgList){
        JSONArray jsonArray=JSONArray.parseArray(imgList);
        System.out.println(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject=jsonArray.getJSONObject(i);
            ImgBase64 imgBase64=JSONObject.parseObject(jsonObject.toJSONString(),ImgBase64.class);
            System.out.println(imgBase64.getImgid());
            base642Img(imgBase64.getImgid(),imgBase64.getImgsrc());
        }
        return "success";
    }

    @DeleteMapping("/deletearticle")
    public void deleteArticle(int id){
        articleRepository.deleteById(id);
    }

    /**
     * 点赞
     *
     * @param id
     */
    @PostMapping("/star")
    public void starClick(int id) {
        articleRepository.updateStarById(id);
    }




    /**
     * base64转换成图片
     *
     * @param base64Str
     */
    public void base642Img(String imgid,String base64Str) {
        final Base64.Decoder decoder = Base64.getDecoder();
        String outBasePath = "S:\\SpringWorkspace\\forum_img_path\\";
        try {
            //解码
            byte[] data = decoder.decode(base64Str);
            //调整异常数据
            for (int i = 0; i < data.length; ++i) {
                if (data[i] < 0) {
                    data[i] += 256;
                }
            }
            String outPath = outBasePath + imgid +".jpg";
            OutputStream out = new FileOutputStream(outPath);
            out.write(data);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**4
     * 图片转换成base64
     * @param imgid
     * @return
     */
    public String img2Base64(String imgid){
        final Base64.Encoder encoder = Base64.getEncoder();
        String inBasePath = "S:\\SpringWorkspace\\forum_img_path\\"+imgid+".jpg";

        InputStream in =null;
        byte[] data=null;
        try {
            in=new FileInputStream(inBasePath);
            data=new byte[in.available()];
            in.read(data);
            in.close();
            String base64Str=encoder.encodeToString(data);
            return base64Str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
