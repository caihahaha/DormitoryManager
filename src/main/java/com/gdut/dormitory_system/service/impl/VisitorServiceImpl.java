package com.gdut.dormitory_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdut.dormitory_system.dao.VisitorDao;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Visitor;
import com.gdut.dormitory_system.entity.vo.QueryVisitorVO;
import com.gdut.dormitory_system.service.VisitorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zwj
 * @Date: 2022/7/27 20:52
 * @Description:
 */
@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorDao visitorDao;

    /**
     * 分页查询
     */
    @Override
    public PageInfo<Visitor> findPageInfo(QueryVisitorVO queryVisitorVO, PageInfo<Visitor> pageInfo) {
        QueryWrapper<Visitor> queryWrapper = new QueryWrapper<>();

        // 多条件组合查询，条件值不为空时才拼接条件
        if (!StringUtils.isEmpty(queryVisitorVO.getName())) {
            // 构建条件，模糊查询
            queryWrapper.like("name", queryVisitorVO.getName());
        }

        if (!StringUtils.isEmpty(queryVisitorVO.getPhone())) {
            queryWrapper.like("phone", queryVisitorVO.getPhone());
        }

        pageInfo = visitorDao.selectPage(pageInfo, queryWrapper);
        // for (Visitor visitor1 : pageInfo.getRecords()) {
        //     System.out.println(visitor1.getName());
        // }
        return pageInfo;
    }

    /**
     * 查询所有访客
     * @return 返回打印的访客列表
     */
    @Override
    public List<Visitor> getAll() {
        List<Visitor> list = visitorDao.selectList(null);
        return list;
    }

    /**
     *
     * @param visitor
     * @return
     */
    @Override
    public int addVisitor(Visitor visitor) {

        return visitorDao.insert(visitor);
    }
}
