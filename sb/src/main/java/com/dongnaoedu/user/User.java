package com.dongnaoedu.user;

import java.io.Serializable;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/10/30
 * 创建时间: 11:02
 */
public class User implements Serializable {
    private String name;
    private String pass;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}
