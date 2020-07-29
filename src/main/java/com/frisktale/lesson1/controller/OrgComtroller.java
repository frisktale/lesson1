package com.frisktale.lesson1.controller;

import java.util.ArrayList;
import java.util.List;

import com.frisktale.lesson1.dao.OrgDao;
import com.frisktale.lesson1.entity.Org;
import com.frisktale.lesson1.service.OrgService;
import com.frisktale.lesson1.util.TreeUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrgComtroller {
    
    @Autowired
    private OrgDao org;

    @Autowired
    private OrgService orgservice;

    @RequestMapping("getAllOrg")
    public List<Org> GetAllOrg() {

        List<Org> data = org.getAllOrg();//接收在数据库中查询到的数据
		List<Org> list = orgservice.GetOrgTree(data);


        return list;
    }
}