package com.frisktale.lesson1.dao;

import java.util.List;

import com.frisktale.lesson1.entity.Org;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OrgDao {
    
    @Select("select * from \"T_DDOrg\"")
    List<Org> getAllOrg();
}