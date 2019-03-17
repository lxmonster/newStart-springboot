package com.restart.spmaster.domain.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Department implements Serializable {
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    @Column(name = "parentId")
    private Integer parentid;

    @Column(name = "depPath")
    private String deppath;

    private Boolean enabled;

    @Column(name = "isParent")
    private Boolean isparent;

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
     * 获取部门名称
     *
     * @return name - 部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部门名称
     *
     * @param name 部门名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return parentId
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * @return depPath
     */
    public String getDeppath() {
        return deppath;
    }

    /**
     * @param deppath
     */
    public void setDeppath(String deppath) {
        this.deppath = deppath == null ? null : deppath.trim();
    }

    /**
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return isParent
     */
    public Boolean getIsparent() {
        return isparent;
    }

    /**
     * @param isparent
     */
    public void setIsparent(Boolean isparent) {
        this.isparent = isparent;
    }
}