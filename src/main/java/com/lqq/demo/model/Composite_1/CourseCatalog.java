package com.lqq.demo.model.Composite_1;

import java.util.ArrayList;
import java.util.List;

//目录类
public class CourseCatalog extends CatalogComponent {

    private List<CatalogComponent> items = new ArrayList<>();
    private String name;
    //添加层级
    private Integer level;

    public CourseCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        items.remove(catalogComponent);
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CatalogComponent catalogComponent : items){
            //进行输出
            if (this.level != null){
                for (int i = 0;i<this.level;i++){
                    System.out.print("-|");
                }
            }
            catalogComponent.print();
        }
    }

    public String getName() {
        return this.name;
    }
}