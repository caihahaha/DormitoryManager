package com.gdut.dormitory_system.controller;

import com.gdut.dormitory_system.entity.PageInfo;
import com.gdut.dormitory_system.entity.Visitor;
import com.gdut.dormitory_system.entity.vo.QueryVisitorVO;
import com.gdut.dormitory_system.service.VisitorService;
import com.gdut.dormitory_system.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zwj
 * @Date: 2022/7/27 20:35
 * @Description: 访客管理
 */
@Controller
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    @Autowired
    private HostHolder hostHolder;

    /**
     * 添加访客信息
     * @param visitor
     * @return
     */
    @PostMapping("/addVisitor")
    @ResponseBody
    public String addVisitor(@RequestBody Visitor visitor) {
        int res = visitorService.addVisitor(visitor);
        return "visitor_list";
    }

    /**
     * 导出excel
     * @return
     */
    @PostMapping("/exportVisitorList")
    @ResponseBody
    public List<Visitor> exportVisitor() {
        List<Visitor> visitorList = visitorService.getAll();
        return visitorList;
    }

    @RequestMapping("/findVisitor")
    public String findVisitor(QueryVisitorVO queryVisitorVO,
                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageIndex,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              Model model) {

        PageInfo<Visitor> page = new PageInfo<>(pageIndex, pageSize);
        page.setPath(("/findVisitor"));
        if (queryVisitorVO == null) {
            queryVisitorVO = new QueryVisitorVO();
        }
        page = visitorService.findPageInfo(queryVisitorVO, page);
        model.addAttribute("page", page);
        // model.addAttribute("admin", hostHolder.getAdmin());
        return "visitor_list";
    }
}
