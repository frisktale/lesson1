package com.frisktale.lesson1.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.frisktale.lesson1.entity.DataTree;

public class TreeUtil {
    
    public static <T extends DataTree<T>> List<T> getTreeList(int topId,List<T> entityList){
		List<T> resultList = new ArrayList<>();//存储顶层的数据
		
		Map<Object, T> treeMap = new HashMap<>();
		T itemTree;
		
		for(int i=0;i<entityList.size()&&!entityList.isEmpty();i++) {
			itemTree = entityList.get(i);
			treeMap.put(itemTree.getID(),itemTree);//把所有的数据放到map当中，id为key
			if(topId==itemTree.getParentID() || itemTree.getParentID() == 0) {//把顶层数据放到集合中
				resultList.add(itemTree);
			}
		}
		
		//循环数据，把数据放到上一级的childen属性中
		for(int i = 0; i< entityList.size()&&!entityList.isEmpty();i++) {
			itemTree = entityList.get(i);
			T data = treeMap.get(itemTree.getParentID());//在map集合中寻找父亲
			if(data != null) {//判断父亲有没有
				if(data.getChildList() == null) {
					data.setChildList(new ArrayList<>());
				}
				data.getChildList().add(itemTree);//把子节点 放到父节点childList当中
				treeMap.put(itemTree.getParentID(), data);//把放好的数据放回map当中
			}
		}
		return resultList;
	}

}