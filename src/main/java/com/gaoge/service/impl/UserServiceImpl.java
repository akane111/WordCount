package com.gaoge.service.impl;

import com.gaoge.dao.UserDao;
import com.gaoge.entity.User;
import com.gaoge.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public void add(User user) {
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userDao.insertSelective(user);
    }

    @Override
    public void update(User user) {
        userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public void delete(String userName) {
        userDao.deleteByPrimaryKey(userName);
    }

    @Override
    public void selectByUserName(String userName) {
        userDao.selectByPrimaryKey(userName);
    }

    @Override
    public PageInfo<User> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userDao.selectAll();
        PageInfo<User> userPageInfo = new PageInfo<User>(users);
        return userPageInfo;
    }

    @Override
    public PageInfo<User> findPage(User user, Integer pageNum, Integer pageSize) {
        Example example = createExample(user);
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userDao.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;
    }

    //创建example
    public Example createExample(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(user.getUserName())) {
            criteria.andLike("userName", "%" + user.getUserName() + "%");
        }
        if (!StringUtils.isEmpty(user.getAddress())){
            criteria.andLike("address", "%" + user.getAddress() + "%");
        }
        return example;
    }
}
