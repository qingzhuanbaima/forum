package com.laboon.controller;


import com.laboon.entity.Lost;
import com.laboon.entity.User;
import com.laboon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author laboon
 * @since 2021-04-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    /**
     * 注册
     * @param
     * @return
     */
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        User exist =userRepository.findByUsername(user.getUsername());
        if(exist!=null){
            return "用户已经存在";
        }else {
            User result = userRepository.save(user);
            if (result != null) {
                return "success";
            } else {
                return "error";
            }
        }
    }

    /**
     * 登录验证
     * @param user
     * @return
     */
    @RequestMapping  ("/login")
    public String login(@RequestBody User user){
        User user1= (User) userRepository.findByUsername(user.getUsername());
        if(user1==null){
            return "用户不存在";
        }
        if(user.getPassword().equals(user1.getPassword())){
            return "success";
        }else {
            return "error";
        }
    }

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    @GetMapping ("/getuser")
    public User getUser(String username){
        System.out.println(username);
        return userRepository.findByUsername(username);
    }
//    public User getUser(User user){
//        System.out.println(user);
//        return userRepository.findByUsername(user.getUsername());
//    }



    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User user) {
        User result = userRepository.save(user);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }
}
