package com.gaoge.controller;

import com.gaoge.common.Result;
import com.gaoge.common.StatusCode;
import com.gaoge.entity.Knowledge;
import com.gaoge.service.KnowledgeService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Api(value = "知识")
@RestController
@RequestMapping("/knowledge")
@CrossOrigin
public class KnowledgeController {
    @Autowired
    private KnowledgeService knowledgeService;

    //分页查询所有知识
    @ApiOperation(value = "分页查询所有知识")
    @GetMapping("/{pageNum}")
    public Result<PageInfo<Knowledge>> findPage(@PathVariable Integer pageNum) {
        PageInfo<Knowledge> knowledgePageInfo = knowledgeService.findPage(pageNum);
        return new Result<PageInfo<Knowledge>>(true, StatusCode.OK,"查询成功",knowledgePageInfo);
    }
    //添加知识
    @ApiOperation(value = "添加知识")
    @PostMapping()
    public Result add(@RequestBody Knowledge knowledge) {
        knowledgeService.add(knowledge);
        return new Result(true, StatusCode.OK,"添加成功");
    }
    //根据id修改知识
    @ApiOperation(value = "根据id修改知识")
    @PutMapping("/{id}")
    public Result update(@RequestBody Knowledge knowledge,
                         @PathVariable("id")Integer id) {
        knowledgeService.update(knowledge,id);
        return new Result(true, StatusCode.OK,"修改成功");
    }
    //根据id删除知识
    @ApiOperation(value = "根据id删除知识")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id")Integer id) {
        knowledgeService.delete(id);
        return new Result(true, StatusCode.OK,"删除成功");
    }


}
