package com.frisktale.lesson1.dao2;

import com.frisktale.lesson1.entity.Org;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("OrgDao2")
@Mapper
public interface OrgDao {
    
    @Select("select * from \"T_DDOrg\"")
    List<Org> getAllOrg();
}