package com.gaoge.service.impl;

import com.gaoge.dao.KnowledgeDao;
import com.gaoge.dao.UserDao;
import com.gaoge.entity.Knowledge;
import com.gaoge.service.KnowledgeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    //每页显示多条数据
    private static final Integer pageSize = 6;
    @Autowired
    private KnowledgeDao knowledgeDao;

    @Override
    public PageInfo<Knowledge> findPage(Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<Knowledge> knowledges = knowledgeDao.selectAll();
        PageInfo<Knowledge> knowledgePageInfo = new PageInfo<>(knowledges);
        return knowledgePageInfo;
    }

    @Override
    public void add(Knowledge knowledge) {
        knowledge.setOwn_name("gaoge");
        knowledge.setCreate_time(new Date());
        knowledge.setUpdate_time(new Date());
        knowledgeDao.insertSelective(knowledge);
    }

    @Override
    public void update(Knowledge knowledge,Integer id) {
        knowledge.setKnowledge_id(id);
        knowledgeDao.updateByPrimaryKeySelective(knowledge);
    }

    @Override
    public void delete(Integer id) {
        knowledgeDao.deleteByPrimaryKey(id);
    }
}
