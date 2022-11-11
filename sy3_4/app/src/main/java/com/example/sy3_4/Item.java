package com.example.sy3_4;

/*
 * 列表的每一个选项
 * */
public class Item {

    private String name;//显示的选项名
    private boolean bo;//记录是否被选中

    //构造函数
    public Item(){
        super();
    }

    //带两个参数的构造函数
    public Item(String name, boolean bo){
        super();
        this.name = name;
        this.bo = bo;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isBo() {
        return bo;
    }
    public void setBo(boolean bo) {
        this.bo = bo;
    }
}

