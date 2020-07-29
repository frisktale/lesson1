package com.frisktale.lesson1.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.frisktale.lesson1.entity.Org;
import com.frisktale.lesson1.util.TreeUtil;


@Service
public class OrgService {
    public List<Org> GetOrgTree(List<Org> data) {

		List<Org> list = new ArrayList<>();//返回的最终集合，可根据自己返回类型更改。
		List<Org> tree = TreeUtil.getTreeList(0, data);//调用工具类，第一个参数是默认传入的顶级id，和查询出来的数据
		Org result = new Org();//我在已经生成好的树形结构外面有包了一层。视情况而定，可以不用写
		result.setID(0);
		result.setName("请选择参与部门");
		result.setChildList(tree);
		list.add(result);//把对象放到list中，前台element-ui中的树形控件需要的是数组的集合


        return list;
    }
}