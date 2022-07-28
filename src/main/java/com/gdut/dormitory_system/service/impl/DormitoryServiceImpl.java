package com.gdut.dormitory_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdut.dormitory_system.dao.DormitoryDao;
import com.gdut.dormitory_system.entity.DormitoryInfo;
import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    private DormitoryDao dormitoryDao;


    /*
        添加宿舍
     */
    @Override
    public Integer addDormitory(DormitoryInfo dormitoryInfo) {

        return dormitoryDao.insert(dormitoryInfo);
    }

    /*
            分页查询
         */
    @Override
    public PageInfo<DormitoryInfo> findDormitory(String adminName, String code, String dormitoryLocation,
                                                 Integer pageNum, Integer pageSize) {
        QueryWrapper<DormitoryInfo> wrapper = new QueryWrapper<>();
        PageInfo<DormitoryInfo> page;
        page = new PageInfo<>(pageNum,pageSize);
        if (adminName!=""&&adminName!=null){
            wrapper.eq("admin_name",adminName);
        }
        if(code!=""&&code!=null){
            wrapper.eq("code",code);
        }
        if(dormitoryLocation!=""&&dormitoryLocation!=null){
            wrapper.eq("dormitory_location",dormitoryLocation);
        }
        dormitoryDao.selectPage(page,wrapper);

//        List<DormitoryInfo> list = page.getRecords();
        return page;
    }

    /*
    查询全部
     */
    @Override
    public List<DormitoryInfo> findAll() {
        List<DormitoryInfo> list =  dormitoryDao.selectList(null);
        return list;
    }


    /*
        删除某一个宿舍
     */
    @Override
    public Integer deleteById(Integer dormitoryId) {
        return dormitoryDao.deleteById(dormitoryId);
    }

    /*
        根据code查找宿舍
     */
    @Override
    public List<DormitoryInfo> findByCode(Integer code) {
        Map<String,Object> cmap = new HashMap<>();
        cmap.put("code",code);
        return dormitoryDao.selectByMap(cmap);
    }

    /*
    根据id查询宿舍
     */
    @Override
    public DormitoryInfo findDormitoryById(Integer id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",id);
        DormitoryInfo dormitoryInfo = dormitoryDao.selectOne(wrapper);
        return dormitoryInfo;
    }

    @Override
    public int updateDormitory(DormitoryInfo dormitoryInfo) {
        int res = dormitoryDao.updateById(dormitoryInfo);
        return  res;
    }


}
