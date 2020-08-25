package com.frisktale.lesson1.controller;

import java.util.List;

import com.frisktale.lesson1.dao.OrgDao;
import com.frisktale.lesson1.entity.Org;
import com.frisktale.lesson1.service.OrgService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrgComtroller {

    @Autowired
    private OrgDao org;

    @Qualifier("OrgDao2")
    @Autowired
    com.frisktale.lesson1.dao2.OrgDao orgDao;

    @Autowired
    private OrgService orgservice;

    @RequestMapping("getAllOrg")
    public List<Org> GetAllOrg() {
//接收在数据库中查询到的数据
        List<Org> data = org.getAllOrg();
        List<Org> list = orgservice.GetOrgTree(data);
        return list;
    }

    @RequestMapping("getAllOrg2")
    public List<Org> GetAllOrg2() {
//接收在数据库中查询到的数据
        List<Org> data = orgDao.getAllOrg();
        List<Org> list = orgservice.GetOrgTree(data);
        return list;
    }
}