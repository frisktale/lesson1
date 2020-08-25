package com.frisktale.lesson1.entity;

import java.util.List;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Org implements DataTree<Org> {
    private int ID;
    private int parentID;
    private String Name;
    private String pMSOrgID;
    private int order;

    private List<Org> childList;

}