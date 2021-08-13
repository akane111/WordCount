package com.gaoge.controller;

import com.gaoge.common.Result;
import com.gaoge.common.StatusCode;
import com.gaoge.entity.User;
import com.gaoge.service.UserService;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    //查询所有用户
    @ApiOperation(value = "查询所有用户")
    @GetMapping
    public Result<List<User>> selectAll() {
        List<User> users = userService.selectAll();
        return new Result<List<User>>(true, StatusCode.OK, "查询成功", users);
    }

    //增加用户
    @ApiOperation(value = "增加用户")
    @PostMapping
    public Result add(//@RequestParam(value = "file", required = false) MultipartFile file,
                      @RequestBody User user
    ) throws IOException {
//        if (file!=null){
//            String originalFilename = file.getOriginalFilename();
//            String tail = originalFilename.substring(originalFilename.lastIndexOf("."));
//            String picName = UUID.randomUUID().toString().replaceAll("-", "") + tail;
//            //图片路径
//            String picPath = "e:" + File.separator + "files";
//            File filePath = new File(picPath);
//            if (!filePath.exists()) {
//                filePath.mkdirs();
//            }
//            //目标文件位置
//            String fileLocation = picPath + File.separator + picName;
//            //设置头像路径
//            user.setAvatar(fileLocation);
//            File targetFile = new File(fileLocation);
//            if (!targetFile.exists()) {
//                targetFile.createNewFile();
//            }
//            //将文件复制到新指定文件名字
//            file.transferTo(targetFile);
//        }
        userService.add(user);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    //修改用户
    @ApiOperation(value = "根据用户名修改用户信息")
    @PutMapping(value = "/{userName}")
    public Result update(@RequestBody User user, @PathVariable("userName") String userName) {
        user.setUserName(userName);
        userService.update(user);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    //删除用户
    @ApiOperation(value = "根据用户名删除用户")
    @DeleteMapping("/{userName}")
    public Result deletes(@PathVariable("userName") String userName) {
        userService.delete(userName);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    //根据用户名查询用户
    @ApiOperation(value = "根据用户名查询用户")
    @GetMapping("/{userName}")
    public Result selectByUserName(@PathVariable("userName") String userName) {
        userService.selectByUserName(userName);
        return new Result(true, StatusCode.OK, "查询成功");
    }

    //分页查询所有用户
    @ApiOperation("分页查询所有用户")
    @GetMapping("/search/{pageNum}/{pageSize}")
    public Result<PageInfo> findPage(@PathVariable("pageNum") Integer pageNum,
                                     @PathVariable("pageSize") Integer pageSize) {
        PageInfo<User> pageInfo = userService.findPage(pageNum, pageSize);
        return new Result<PageInfo>(true, StatusCode.OK, "分页查询成功", pageInfo);
    }
    //分页条件查询
    @ApiOperation("分页条件查询用户")
    @PostMapping("/search/{pageNum}/{pageSize}")
    public Result<PageInfo> findPage(@RequestBody User user,
                                     @PathVariable("pageNum") Integer pageNum,
                                     @PathVariable("pageSize") Integer pageSize) {
        PageInfo<User> pageInfo = userService.findPage(user, pageNum, pageSize);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }
}
