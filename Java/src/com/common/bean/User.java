package com.common.bean;

/**
 * Created by liyu on 2017/6/3.
 */
public class User {
    private int id;

    private String name;

    private int age;

    private String sex;

    public User() {}

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(int id, String name, int age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
