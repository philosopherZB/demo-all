package com.philosopherzb.commonutil.mapstruct.bo;

import java.util.Date;

/**
 * @author philosopherZB
 * @date 2022/8/29
 */
//@Data--不能使用lombok，否则提示属性找不到
public class PersonBO {
    private Integer id;

    private String name;

    private int age;

    private Date birthday;

    private String gender;

    private String testFiled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTestFiled() {
        return testFiled;
    }

    public void setTestFiled(String testFiled) {
        this.testFiled = testFiled;
    }
}
