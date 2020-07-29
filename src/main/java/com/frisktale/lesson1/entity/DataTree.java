package com.frisktale.lesson1.entity;

import java.util.List;

public interface DataTree<T> {
	
    public int getID();
	
    public int getParentID();
    
    public void setChildList(List<T> childList);
    
    public List<T> getChildList();
}