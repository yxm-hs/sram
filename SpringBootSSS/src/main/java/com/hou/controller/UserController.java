package com.hou.controller;

import com.hou.common.CodeMenu;
import com.hou.common.ResponseResult;
import com.hou.dao.UserDao;
import com.hou.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin// 跨域请求
public class UserController {

    @Autowired
    private UserDao userDao;
    //@RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @GetMapping("/findAll")
    public ResponseResult<User> findAll(){

        List<User> userList = userDao.findAll();

        ResponseResult<User> rr= new ResponseResult<>(true, CodeMenu.SUCCESS);
        rr.setUser(new User());
        rr.setUserList(userList);
        return rr;
    }
    @GetMapping("/findById")//  5000+   1000+100+1000
    public ResponseResult<User> findUserById(int id){
        Optional<User> optional = userDao.findById(id);
        User user = optional.get();
        ResponseResult<User> rr= new ResponseResult<>(true, CodeMenu.SUCCESS);
        rr.setUser(user);
        rr.setUserList(new ArrayList<>());
        return rr;
    }

    @PostMapping("/updateUser")
    public ResponseResult<User> findUserById(@RequestBody  User user){
        //User user1 = userDao.findById(user.getId()).get();
        userDao.save(user);
        ResponseResult<User> rr= new ResponseResult<>(true, CodeMenu.SUCCESS);
        rr.setUser(new User());
        rr.setUserList(new ArrayList<>());
        return rr;
    }

}
