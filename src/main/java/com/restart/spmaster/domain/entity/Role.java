package com.restart.spmaster.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Role implements Serializable {
    private Integer id;

    private String name;

    /**
     * 角色名称
     */
    @Column(name = "nameZh")
    private String namezh;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取角色名称
     *
     * @return nameZh - 角色名称
     */
    public String getNamezh() {
        return namezh;
    }

    /**
     * 设置角色名称
     *
     * @param namezh 角色名称
     */
    public void setNamezh(String namezh) {
        this.namezh = namezh == null ? null : namezh.trim();
    }
}