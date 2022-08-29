package com.philosopherzb.commonutil.mapstruct.bo;

import com.philosopherzb.commonutil.mapstruct.constant.Gender;

import java.util.Date;

/**
 * @author philosopherZB
 * @date 2022/8/29
 */
//@Data--不能使用lombok，否则提示属性找不到
public class PersonVO {

    private String userName;

    private Integer age;

    private Date birthday;

    private Gender gender;

    private String testFiled2;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getTestFiled2() {
        return testFiled2;
    }

    public void setTestFiled2(String testFiled2) {
        this.testFiled2 = testFiled2;
    }
}
