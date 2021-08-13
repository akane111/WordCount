package com.gaoge.controller;

import com.gaoge.common.Result;
import com.gaoge.common.StatusCode;
import com.gaoge.dao.OrderDao;
import com.gaoge.entity.Order;
import com.gaoge.service.OrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    //查询所有订单
    @ApiOperation(value = "查询所有订单")
    @GetMapping
    public Result<List<Order>> selectAll() {
        List<Order> orders = orderService.selectAll();
        return new Result<List<Order>>(true, StatusCode.OK, "查询成功", orders);
    }

    //查询所有货源(商品)订单
    @ApiOperation(value = "分页查询所有货源(商品)订单")
    @GetMapping("/goods/{pageNum}")
    public Result<PageInfo> selectAllGoods(@PathVariable("pageNum") Integer pageNum) {
        PageInfo<Order> orders = orderService.selectAllGoods(pageNum);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", orders);
    }

    //查询所有需求订单
    @ApiOperation(value = "分页查询所有需求订单")
    @GetMapping("/needs/{pageNum}")
    public Result<PageInfo> selectAllNeeds(@PathVariable("pageNum") Integer pageNum) {
        PageInfo<Order> orders = orderService.selectAllNeeds(pageNum);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", orders);
    }

    //添加订单
    @ApiOperation(value = "添加订单")
    @PostMapping
    public Result add(@RequestBody Order order) {
        orderService.add(order);
        return new Result(true, StatusCode.OK, "添加订单成功");
    }

    //修改id订单
    @ApiOperation(value = "根据id修改订单")
    @PutMapping("/{id}")
    public Result update(@RequestBody Order order,
                         @PathVariable Integer id) {
        orderService.update(order, id);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    //删除订单
    @ApiOperation(value = "根据id删除订单")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        orderService.delete(id);
        return new Result(true, StatusCode.OK, "删除订单");
    }
}
