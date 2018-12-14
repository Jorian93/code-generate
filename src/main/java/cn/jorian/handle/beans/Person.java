package cn.jorian.handle.beans;

import cn.jorian.handle.annotation.PrimaryKey;

/**
 * @Author: wugui
 * @Date 2018-9-7 00:02
 */
public class Person {
    @PrimaryKey
    private String id;
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
