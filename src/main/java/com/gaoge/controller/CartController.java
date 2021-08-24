package com.gaoge.controller;

import com.gaoge.common.Result;
import com.gaoge.common.StatusCode;
import com.gaoge.entity.Order;
import com.gaoge.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 购物车
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private OrderService orderService;

    //添加商品到购物车
    @ApiOperation("添加商品到购物车")
    @GetMapping("/add/{id}")
    public Result add(@PathVariable("id") Integer id) {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
//        redisTemplate.boundListOps(name).leftPush(id);
//        redisTemplate.boundHashOps(name).put(id,id);
        redisTemplate.boundZSetOps(name).add(id,100);
        return new Result(true, StatusCode.OK, "添加商品到购物车成功");
    }

    //从购物车删除商品
    @ApiOperation("从购物车删除商品")
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
//        redisTemplate.boundHashOps(name).delete(id);
//        redisTemplate.boundListOps(name).remove(1, id);
        redisTemplate.boundZSetOps(name).remove(id);
        return new Result(true, StatusCode.OK, "删除商品成功");
    }

    //展示购物车列表
    @ApiOperation("展示购物车列表")
    @GetMapping("/show")
    public Result<List<Order>> show() {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
//        redisTemplate.boundHashOps(name).delete(id);
//        Long size = redisTemplate.boundListOps(name).size();
//        List<Integer> list = redisTemplate.boundListOps(name).range(0, size);
        Long size = redisTemplate.boundZSetOps(name).size();
        Set<Integer> range = redisTemplate.boundZSetOps(name).range(0, size);
       ArrayList<Order> orders = new ArrayList<>();
//        LinkedHashSet<Integer> integers = new LinkedHashSet<>();

        for (Integer id : range) {
            Order order = orderService.selectById(id);
            orders.add(order);
        }
        return new Result<List<Order>>(true, StatusCode.OK, "查询成功", orders);
    }

    //提交订单
    @ApiOperation("提交订单")
    @GetMapping("/commitOrder")
    public Result<Integer> commitOrder() {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < redisTemplate.boundListOps(name).size(); i++) {
            Integer id = (Integer) redisTemplate.boundListOps(name).leftPop();
            integers.add(id);
        }
        return new Result(true, StatusCode.OK, "提交成功", integers);
    }
}
