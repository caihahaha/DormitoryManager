package com.gdut.dormitory_system.service;

import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Visitor;
import com.gdut.dormitory_system.entity.vo.QueryVisitorVO;

import java.util.List;

/**
 * @Author: zwj
 * @Date: 2022/7/27 20:50
 * @Description:
 */
public interface VisitorService {

    PageInfo<Visitor> findPageInfo(QueryVisitorVO queryVisitorVO, PageInfo<Visitor> page);

    List<Visitor> getAll();

    int addVisitor(Visitor visitor);

}
